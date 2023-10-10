package com.example.demo.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.grievance.dto.UpdateTicketInDto;
import com.grievance.entity.TicketStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UpdateTicketInDtoTest {
  UpdateTicketInDto updateTicketInDto;

  @BeforeEach
  void setup() {
    updateTicketInDto = new UpdateTicketInDto();
    updateTicketInDto.setEmpName("Adarsh");
  }

  @Test
  void settergetter() {
    org.junit.jupiter.api.Assertions.assertEquals(
        "Adarsh",
        updateTicketInDto.getEmpName()
    );
  }

  @Test
  void hashCodeTest() {
    UpdateTicketInDto update = new UpdateTicketInDto();
    update.setComment("adarsh");
    update.setEmpName("Arpit");
    update.setStatus(TicketStatus.BEING_ADDRESSED);

    UpdateTicketInDto update1 = new UpdateTicketInDto();
    update1.setComment("adarsh");
    update1.setEmpName("Arpit");
    update1.setStatus(TicketStatus.BEING_ADDRESSED);

    UpdateTicketInDto update2 = new UpdateTicketInDto();
    update2.setComment("adarsh");
    update2.setEmpName("Arp");
    update2.setStatus(TicketStatus.BEING_ADDRESSED);

    assertEquals(update.hashCode(), update1.hashCode());
    assertNotEquals(update.hashCode(), update2.hashCode());
  }

  @Test
  void equalsTest() {
    UpdateTicketInDto update = new UpdateTicketInDto();
    update.setComment("adarsh");
    update.setEmpName("Arpit");
    update.setStatus(TicketStatus.BEING_ADDRESSED);

    UpdateTicketInDto update1 = new UpdateTicketInDto();
    update1.setComment("adarsh");
    update1.setEmpName("Arpit");
    update1.setStatus(TicketStatus.BEING_ADDRESSED);

    UpdateTicketInDto update2 = new UpdateTicketInDto();
    update2.setComment("adarsh");
    update2.setEmpName("Arp");
    update2.setStatus(TicketStatus.BEING_ADDRESSED);

    assertThat(update.equals(update1));
    assertThat(!update.equals(update2));
    assertThat(update.equals(update));
    assertThat(!update.equals(null));
    assertThat(!update.equals(new Department()));
  }
}
