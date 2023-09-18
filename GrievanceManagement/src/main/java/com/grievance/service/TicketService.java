package com.grievance.service;

import com.grievance.dto.DepartmentOutDto;
import com.grievance.dto.EmployeeOutDto;
import com.grievance.dto.TicketDto;
import com.grievance.dto.TicketOutDto;
import com.grievance.dto.TicketOutDtoWithComments;
import com.grievance.dto.UpdateTicketInDto;
import com.grievance.entity.Comment;
import com.grievance.entity.Department;
import com.grievance.entity.Employee;
import com.grievance.entity.Role;
import com.grievance.entity.Ticket;
import com.grievance.entity.TicketStatus;
import com.grievance.entity.TicketType;
import com.grievance.exception.ResourceNotFound;
import com.grievance.repo.TicketRepo;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Ticket Service .
 */
@Service
public class TicketService {
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
   * @param ticketDto type TicketDto.
   *
   * @return TicketOutDto.
   */
  public TicketOutDto addTicket(final TicketDto ticketDto) {
    Ticket ticket = this.mapper.map(ticketDto, Ticket.class);

    //    Date in = new Date();
    //    LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(),
    //         ZoneId.systemDefault());
    //    Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());

    ticket.setCreationDate(getCurrentDateTime());
    ticket.setLastUpdateDate(getCurrentDateTime());

    Ticket savedTicket = this.ticketRepo.save(ticket);

    return this.mapper.map(savedTicket, TicketOutDto.class);
  }

  /**
   * get all tickets.
   *
   * @return List of TicketDto.
   */
  public List<TicketDto> getAllTickets() {
    List<Ticket> tickets = this.ticketRepo.findAll();

    List<TicketDto> ticketDtos = new ArrayList<TicketDto>();
    for (Ticket ticket : tickets) {
      ticketDtos.add(this.mapper.map(ticket, TicketDto.class));
    }

    return ticketDtos;
  }

  /**
   * Find all Ticket.
   *
   * @return TicketOutDto
   */
  public List<TicketOutDto> findAll(final Integer id, String type) {
    List<TicketOutDto> result = new ArrayList<TicketOutDto>();

    List<Ticket> ticket = null;
    EmployeeOutDto emp = this.employeeService.getById(id);
    if (emp.getRole() == Role.ROLE_ADMIN) {

      if (type.equals("department")) {
        ticket = this.ticketRepo.findByStatus();
      } else {
    	TicketStatus[] status = {TicketStatus.OPEN,TicketStatus.BEING_ADDRESSED,TicketStatus.RESOLVED};
        Employee employee = this.mapper.map(emp, Employee.class);
        ticket = this.ticketRepo.findByStatusInAndEmployee(status, employee);
        
      }
    } else {
      TicketStatus[] status = {TicketStatus.OPEN,TicketStatus.BEING_ADDRESSED,TicketStatus.RESOLVED};
      if (type.equals("department")) {
        DepartmentOutDto dep = emp.getDepartment();
        ticket = this.ticketRepo.findByDepartmentAndStatus(
              this.mapper.map(dep, Department.class), status);
      } else {
    	  Employee employee = this.mapper.map(emp, Employee.class);
    	  ticket = this.ticketRepo.findByStatusInAndEmployee(status, employee);
      }
    }
    for (Ticket temp : ticket) {
      result.add(this.mapper.map(temp, TicketOutDto.class));
    }
    return result;
  }

  /**
   * Update Ticket.
   *
   * @param id Integer
   * @param ticketDto TicketDto
   * @return TicketOutDto
   */
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
  public TicketOutDtoWithComments ticketById(Integer id) {
    Ticket ticket = this.ticketRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFound("Ticket", "Ticket not found"));
    return this.mapper.map(ticket, TicketOutDtoWithComments.class);
  }
}
