package com.example.demo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.dto.TicketInDto;
import com.grievance.entity.TicketStatus;
import com.grievance.entity.TicketType;

public class TicketDtoTest {
	
	TicketInDto ticket ;
	
	@BeforeEach
	public void setup() {
		ticket = new TicketInDto("test" , "test" , TicketStatus.BEING_ADDRESSED , TicketType.GRIEVANCE , null , null);
	}
	
	@Test
	public void toString_Testing() {
		String value = "TicketDto [ticketName=test, description=test, status=BEING_ADDRESSED, ticketType=GRIEVANCE, department=null, employee=null]";
		assertEquals(ticket.toString(), value);
	}
}

