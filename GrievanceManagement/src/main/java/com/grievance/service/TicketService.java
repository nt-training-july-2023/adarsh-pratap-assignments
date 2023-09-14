package com.grievance.service;

import com.grievance.dto.EmployeeOutDto;
import com.grievance.dto.EmployeesDto;
import com.grievance.dto.TicketDto;
import com.grievance.dto.TicketOutDto;
import com.grievance.entity.Department;
import com.grievance.entity.Employee;
import com.grievance.entity.Role;
import com.grievance.entity.Ticket;
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

    Date in = new Date();
    LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(),
         ZoneId.systemDefault());
    Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());

    ticket.setCreationDate(out);
    ticket.setLastUpdateDate(out);

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
  public List<TicketOutDto> findAll(final Integer id) {
    List<TicketOutDto> result = new ArrayList<TicketOutDto>();

    EmployeeOutDto emp = this.employeeService.getById(id);
    if (emp.getRole() == Role.ROLE_ADMIN) {
      List<Ticket> ticket = this.ticketRepo.findAll();

      for (Ticket temp : ticket) {
        result.add(this.mapper.map(temp, TicketOutDto.class));
      }
      return result;
    }

    List<Ticket> ticket = emp.getTicket();
    ticket.addAll(this.ticketRepo.findByDepartment(emp.getDepartment()));
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
  public TicketOutDto updateTicket(
      final Integer id, final TicketDto ticketDto) {
    Ticket ticket =
        this.ticketRepo.findById(id)
        .orElseThrow(() ->
        new ResourceNotFound("Ticket", "Ticket Not found"));

    ticket.setDepartment(ticketDto.getDepartment());
    ticket.setDescription(ticketDto.getDescription());
    ticket.setTicketName(ticketDto.getTicketName());
    ticket.setTicketType(ticketDto.getTicketType());
    ticket.setStatus(ticketDto.getStatus());
    ticket.setEmployee(ticketDto.getEmployee());

    return this.mapper.map(this.ticketRepo.save(ticket), TicketOutDto.class);
  }
}
