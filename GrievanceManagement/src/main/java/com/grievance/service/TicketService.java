package com.grievance.service;

import com.grievance.dto.TicketDto;
import com.grievance.entity.Ticket;
import com.grievance.repo.TicketRepo;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Ticket Service .
 */
public class TicketService {
  @Autowired
  private TicketRepo ticketRepo;

  @Autowired
  private ModelMapper mapper;

  /**
   * save ticket.
   */
  public TicketDto addTicket(TicketDto ticketDto) {
    Ticket ticket = this.mapper.map(ticketDto, Ticket.class);

    Ticket savedTicket = this.ticketRepo.save(ticket);

    return this.mapper.map(savedTicket, TicketDto.class);
  }

  /**
   * get all Tickets.
   */
  public List<TicketDto> getAllTickets() {
    List<Ticket> tickets = this.ticketRepo.findAll();

    List<TicketDto> ticketDtos = new ArrayList<TicketDto>();
    for (Ticket ticket : tickets) {
      ticketDtos.add(this.mapper.map(ticket, TicketDto.class));
    }

    return ticketDtos;
  }
}
