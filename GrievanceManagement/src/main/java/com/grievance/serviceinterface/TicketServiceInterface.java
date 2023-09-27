package com.grievance.serviceinterface;

import com.grievance.dto.TicketInDto;
import com.grievance.dto.TicketOutDto;
import com.grievance.dto.TicketOutDtoWithComments;
import com.grievance.dto.UpdateTicketInDto;
import java.util.List;

/**
 * Ticket service Interface.
 */
public interface TicketServiceInterface {
  /**
   * Get ticket By Id.
   *
   * @param id Integer
   * @return TicketOutDtoWithComments
   */
  TicketOutDtoWithComments ticketById(Integer id);

  /**
   * Update Ticket.
   *
   * @param id Integer
   * @param ticketDto TicketDto
   * @return TicketOutDto
   */
  TicketOutDtoWithComments updateTicket(
      Integer id, UpdateTicketInDto ticketDto);

  /**
   * Find all Ticket.
   *
   * @param id Integer
   * @param type String
   * @param filter String
   * @param offset Integer
   * @return List of TicketOutDto
   */
  List<TicketOutDto> findAll(
       Integer id, String type, String filter, Integer offset);

  /**
   * Add Ticket.
   *
   * @param ticketInDto type TicketDto.
   *
   * @return TicketOutDto.
   */
  TicketOutDto addTicket(TicketInDto ticketInDto);
}
