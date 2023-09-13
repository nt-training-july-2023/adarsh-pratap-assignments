package com.grievance.controller;

import javax.validation.Valid;

import com.grievance.dto.TicketDto;
import com.grievance.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Ticket Controller.
 */
@RestController
@RequestMapping("/ticket")
@CrossOrigin("*")
public class TicketController {
  /**
   * TicketService Autowired.
   */
  @Autowired
  private TicketService ticketService;

  /**
   * Create new ticket.
   *
   * @param ticketDto TicketDto
   *
   * @return ResponseEntity
   */
  @PostMapping("/add")
  public ResponseEntity<?> createTicket(
      final @Valid @RequestBody TicketDto ticketDto) {
    return new ResponseEntity<>(
      this.ticketService.addTicket(ticketDto),
      HttpStatus.CREATED
    );
  }

  /**
   * Get all tickets.
   *
   * @param id EmployeeDto
   *
   * @return ResponseEntity
   */
  @GetMapping("/getall/{id}")
  public ResponseEntity<?> getAllTickets(final @PathVariable Integer id) {
    return new ResponseEntity<>(
      this.ticketService.findAll(id),
      HttpStatus.OK);
  }

  /**
   * Update Ticket.
   *
   * @param id Integer
   * @param ticket Ticket
   *
   * @return ResponseEntity
   */
  @PutMapping("/update/{id}")
  public ResponseEntity<?> updateTicket(
      final @PathVariable(name = "id") Integer id,
      final @RequestBody TicketDto ticket) {
    return new ResponseEntity<>(
    this.ticketService.updateTicket(id, ticket), HttpStatus.OK);
  }
}
