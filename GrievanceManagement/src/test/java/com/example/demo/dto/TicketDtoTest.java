package com.example.demo.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.grievance.dto.TicketInDto;
import com.grievance.entity.TicketStatus;
import com.grievance.entity.TicketType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketDtoTest {
  TicketInDto ticket;

  @BeforeEach
  public void setup() {
    ticket =
      new TicketInDto(
        "test",
        "test",
        TicketStatus.BEING_ADDRESSED,
        TicketType.GRIEVANCE,
        null,
        null
      );
  }

  @Test
  public void toString_Testing() {
    String value =
      "TicketDto [ticketName=test, description=test, status=BEING_ADDRESSED, ticketType=GRIEVANCE, department=null, employee=null]";
    assertEquals(ticket.toString(), value);
  }

  @Test
  public void hashCodeTest() {
    TicketInDto ticket = new TicketInDto();
    ticket.setDescription("adarsh");
    ticket.setStatus(TicketStatus.BEING_ADDRESSED);
    ticket.setTicketName("adarsh");
    ticket.setTicketType(TicketType.FEEDBACK);

    TicketInDto ticket1 = new TicketInDto();
    ticket1.setDescription("adarsh");
    ticket1.setStatus(TicketStatus.BEING_ADDRESSED);
    ticket1.setTicketName("adarsh");
    ticket1.setTicketType(TicketType.FEEDBACK);

    TicketInDto ticket2 = new TicketInDto();
    ticket2.setDescription("adarsh");
    ticket2.setStatus(TicketStatus.BEING_ADDRESSED);
    ticket2.setTicketName("ada");
    ticket2.setTicketType(TicketType.FEEDBACK);

    assertEquals(ticket.hashCode(), ticket1.hashCode());
    assertNotEquals(ticket.hashCode(), ticket2.hashCode());
  }

  @Test
  public void equalsTest() {
    TicketInDto ticket = new TicketInDto();
    ticket.setDescription("adarsh");
    ticket.setStatus(TicketStatus.BEING_ADDRESSED);
    ticket.setTicketName("adarsh");
    ticket.setTicketType(TicketType.FEEDBACK);

    TicketInDto ticket1 = new TicketInDto();
    ticket1.setDescription("adarsh");
    ticket1.setStatus(TicketStatus.BEING_ADDRESSED);
    ticket1.setTicketName("adarsh");
    ticket1.setTicketType(TicketType.FEEDBACK);

    TicketInDto ticket2 = new TicketInDto();
    ticket2.setDescription("adarsh");
    ticket2.setStatus(TicketStatus.BEING_ADDRESSED);
    ticket2.setTicketName("ada");
    ticket2.setTicketType(TicketType.FEEDBACK);

    assertThat(ticket.equals(ticket1));
    assertThat(!ticket.equals(ticket2));
    assertThat(ticket.equals(ticket));
    assertThat(!ticket.equals(null));
    assertThat(!ticket.equals(new Department()));
  }
}
