package com.grievance.service;

import com.grievance.dto.TicketDto;
import com.grievance.dto.TicketOutDto;
import com.grievance.entity.Ticket;
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
  @Autowired
  private TicketRepo ticketRepo;

  @Autowired
  private ModelMapper mapper;

  /**
   * save ticket.
   */
  public TicketOutDto addTicket(TicketDto ticketDto) {
    Ticket ticket = this.mapper.map(ticketDto, Ticket.class);
    
    Date in = new Date();
    LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
    Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    
    ticket.setCreationDate(out);
    ticket.setLastUpdateDate(out);

    Ticket savedTicket = this.ticketRepo.save(ticket);

    return this.mapper.map(savedTicket, TicketOutDto.class);
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
