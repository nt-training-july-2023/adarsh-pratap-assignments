package com.grievance.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.grievance.dto.EmployeeOutDto;
import com.grievance.dto.TicketInDto;
import com.grievance.dto.TicketOutDto;
import com.grievance.dto.TicketOutDtoWithComments;
import com.grievance.dto.UpdateTicketInDto;
import com.grievance.entity.Comment;
import com.grievance.entity.Department;
import com.grievance.entity.Employee;
import com.grievance.entity.Role;
import com.grievance.entity.Ticket;
import com.grievance.entity.TicketStatus;
import com.grievance.exception.ResourceNotFound;
import com.grievance.repo.TicketRepo;
import com.grievance.serviceinterface.TicketServiceInterface;

/**
 * Ticket Service .
 */
@Service
public class TicketService implements TicketServiceInterface{
  /**
   * Ticket Repository.
   */
  @Autowired
  private TicketRepo ticketRepo;

  /**
   * Employee Service.
   */
  @Autowired
  private EmployeeService employeeService;

  /**
   * Model Mapper .
   */
  @Autowired
  private ModelMapper mapper;

  /**
   * Add Ticket.
   *
   * @param ticketInDto type TicketDto.
   *
   * @return TicketOutDto.
   */
  @Override
  public TicketOutDto addTicket(final TicketInDto ticketInDto) {
    Ticket ticket = this.mapper.map(ticketInDto, Ticket.class);

    ticket.setCreationDate(getCurrentDateTime());
    ticket.setLastUpdateDate(getCurrentDateTime());

    Ticket savedTicket = this.ticketRepo.save(ticket);

    return this.mapper.map(savedTicket, TicketOutDto.class);
  }


  /**
   * Find all Ticket.
   *
   * @return TicketOutDto
   */
  @Override
  public List<TicketOutDto> findAll(final Integer id, String type, String filter, Integer offset) {
	  System.out.println(type+" "+filter + " " + offset);
	  Page<Ticket> ticket = null;
	  EmployeeOutDto emp = this.employeeService.getById(id);
	  if (emp.getRole().equals(Role.ROLE_ADMIN)) {
		  ticket = ticketForAdmin(filter, type, emp, offset);
	  }
	  else {
		  ticket = ticketForUser(filter, type, emp, offset);
	  }
	  List<TicketOutDto> result = new ArrayList<TicketOutDto>();
	  for (Ticket temp : ticket) {
	      result.add(this.mapper.map(temp, TicketOutDto.class));
	    }
	    return result;
  }

  
  private Page<Ticket> ticketForUser(String filter,String type,EmployeeOutDto emp,Integer offset){
	  Department department = this.mapper.map(emp.getDepartment(),Department.class);
		Employee employee = this.mapper.map(emp, Employee.class);
		
	    if (filter.equals("all")) {
	    	Pageable page = PageRequest.of(offset, 5, Sort.by("status"));
	    	if (type.equals("my")) {
	    		return this.ticketRepo.findByEmployee(employee, page);
	    	}
	    	else if (type.equals("all")) {
	    		return this.ticketRepo.findByEmployeeOrDepartment(employee, department, page);
	    	}
	    	else {
	    		return this.ticketRepo.findByDepartment(department, page);
	    	}
	    }
	    else {
	    	Pageable page = PageRequest.of(offset, 5);
	    	TicketStatus status = null;
	    	
	    	if (filter.equals("open")) {
	    		status = TicketStatus.OPEN;
	    	}
	    	else if(filter.equals("resolved")) {
	    		status = TicketStatus.RESOLVED;
	    	}
	    	else {
	    		status = TicketStatus.BEING_ADDRESSED;
	    	}
	    	
	    	if (type.equals("my")) {
	    		return this.ticketRepo.findByEmployeeAndStatus(employee, status, page);
	    	}
	    	else if (type.equals("all")) {
	    		return this.ticketRepo.findByStatusAndDepartmentOrEmployee(department, employee, status, page);
	    	}
	    	else {
	    		return this.ticketRepo.findByDepartmentAndStatus(department, status, page);
	    	}
	    }
	
  }

private Page<Ticket> ticketForAdmin(String filter,String type,EmployeeOutDto emp,Integer offset){
	Department department = this.mapper.map(emp.getDepartment(),Department.class);
	Employee employee = this.mapper.map(emp, Employee.class);
	
    if (filter.equals("all")) {
    	Pageable page = PageRequest.of(offset, 5, Sort.by("status"));
    	if (type.equals("my")) {
    		return this.ticketRepo.findByEmployee(employee, page);
    	}
    	else if (type.equals("all")) {
    		return this.ticketRepo.findAll(page);
    	}
    	else {
    		return this.ticketRepo.findByDepartment(department, page);
    	}
    }
    else {
    	Pageable page = PageRequest.of(offset, 5);
    	TicketStatus status = null;
    	
    	if (filter.equals("open")) {
    		status = TicketStatus.OPEN;
    	}
    	else if(filter.equals("resolved")) {
    		status = TicketStatus.RESOLVED;
    	}
    	else {
    		status = TicketStatus.BEING_ADDRESSED;
    	}
    	
    	if (type.equals("my")) {
    		return this.ticketRepo.findByEmployeeAndStatus(employee, status, page);
    	}
    	else if (type.equals("all")) {
    		return this.ticketRepo.findByStatus(status, page);
    	}
    	else {
    		return this.ticketRepo.findByDepartmentAndStatus(department, status, page);
    	}
    }
  }

/**
   * Update Ticket.
   *
   * @param id Integer
   * @param ticketDto TicketDto
   * @return TicketOutDto
   */
  @Override
  public TicketOutDto updateTicket(final Integer id, final UpdateTicketInDto ticketDto) {
    Ticket ticket =
        this.ticketRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFound("Ticket", "Ticket Not found"));

    if (ticketDto.getComment() != null && !ticketDto.getComment().isEmpty()) {
      Comment comment = new Comment();
      comment.setContent(ticketDto.getComment());
      comment.setCreationTime(getCurrentDateTime());
      comment.setEmpName(ticket.getEmployee().getUserName());
      comment.setTicket(ticket);

      List<Comment> comments = ticket.getComments();
      comments.add(comment);

      ticket.setComments(comments);
    }
    ticket.setStatus(ticketDto.getStatus());
    ticket.setLastUpdateDate(getCurrentDateTime());
    return this.mapper.map(this.ticketRepo.save(ticket), TicketOutDto.class);
  }

  /**
   * Get current Date and time.
   *
   * @return Date.
   */
  public Date getCurrentDateTime() {
    Date in = new Date();
    LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
    Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    return out;
  }

  /**
   * Get ticket By Id.
   *
   * @param id Integer
   * @return TicketOutDtoWithComments
   */
  @Override
  public TicketOutDtoWithComments ticketById(Integer id) {
    Ticket ticket = this.ticketRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFound("Ticket", "Ticket not found"));
    return this.mapper.map(ticket, TicketOutDtoWithComments.class);
  }
}
