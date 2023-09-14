package com.example.demo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.dto.TicketOutDto;
import com.grievance.entity.TicketStatus;
import com.grievance.entity.TicketType;

public class TicketOutDtoTest {
	
	TicketOutDto ticket;
	
	@BeforeEach
	public void setup() {
		ticket = new TicketOutDto();
		ticket.setComments(null);
		ticket.setCreationDate(null);
		ticket.setDepartment(null);
		ticket.setDescription("testing the api");
		ticket.setEmployee(null);
		ticket.setLastUpdateDate(null);
		ticket.setStatus(TicketStatus.BEING_ADDRESSED);
		ticket.setTicketId(1);
		ticket.setTicketName("Testing");
		ticket.setTicketType(TicketType.FEEDBACK);
	}
	
	@Test
	public void getters_Testing() {
		assertEquals(ticket.getComments(), null);
		assertEquals(ticket.getCreationDate(), null);
		assertEquals(ticket.getDepartment(), null);
		assertEquals(ticket.getDescription(), "testing the api");
		assertEquals(ticket.getEmployee(), null);
		assertEquals(ticket.getLastUpdateDate(), null);
		assertEquals(ticket.getStatus(), TicketStatus.BEING_ADDRESSED);
		assertEquals(ticket.getTicketId(), (Integer)1);
		assertEquals(ticket.getTicketName(), "Testing");
		assertEquals(ticket.getTicketType(), TicketType.FEEDBACK);
	}
	
	@Test
	public void toString_Testing() {
		String value = "TicketOutDto [ticketId=1, ticketName=Testing, description=testing the api, status=BEING_ADDRESSED, creationDate=null, lastUpdateDate=null, ticketType=FEEDBACK, department=null, employee=null, comments=null]";
		assertEquals(ticket.toString(), value);
	}
	
}

