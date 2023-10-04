package com.grievance.controller;

import com.grievance.dto.TicketInDto;
import com.grievance.dto.UpdateTicketInDto;
import com.grievance.service.TicketService;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Ticket Controller.
 *
 * @author adarsh
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
   * Logger.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(
        EmployeeController.class);

  /**
   * Create new ticket.
   *
   * @param ticketInDto TicketDto
   *
   * @return ResponseEntity
   */
  @PostMapping("/add")
  public ResponseEntity<?> createTicket(
      final @Valid @RequestBody TicketInDto ticketInDto) {
    LOGGER.info("Inside Create Ticket Controller!!!");
    return new ResponseEntity<>(
      this.ticketService.addTicket(ticketInDto),
      HttpStatus.CREATED
    );
  }

  /**
   * Get all tickets.
   *
   * @param empid Integer
   * @param ticket String
   * @param filter String
   * @param offset Integer
   *
   * @return ResponseEntity
   */
  @GetMapping("/getall")
  public ResponseEntity<?> getAllTickets(
      final @RequestParam Integer empid,
      final @RequestParam String ticket,
      final @RequestParam String filter,
      final @RequestParam Integer offset) {
    LOGGER.info("Inside Get All Ticket Controller!!!");
    return new ResponseEntity<>(
      this.ticketService.findAll(empid, ticket, filter, offset),
      HttpStatus.OK);
  }

  /**
   * Update Ticket.
   *
   * @param id Integer
   * @param ticket UpdateTicketInDto
   *
   * @return ResponseEntity
   */
  @PutMapping("/update/{id}")
  public ResponseEntity<?> updateTicket(
      final @PathVariable(name = "id") Integer id,
      final @Valid @RequestBody UpdateTicketInDto ticket) {
    LOGGER.info("Inside Update Ticket Controller!!!");
    return new ResponseEntity<>(
    this.ticketService.updateTicket(id, ticket), HttpStatus.OK);
  }

  /**
   * Get Ticket By Id.
   *
   * @param id Integer
   * @return Response Entity
   */
  @GetMapping("/get/{id}")
  public ResponseEntity<?> getTicketById(
      final @PathVariable(name = "id") Integer id) {
    LOGGER.info("Inside Get All Employee Controller!!!");
    return new ResponseEntity<>(
        this.ticketService.ticketById(id), HttpStatus.OK);
  }
}
