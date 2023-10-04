package com.example.demo.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import javax.net.ssl.SSLEngineResult.Status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.entity.Department;
import com.grievance.entity.Employee;
import com.grievance.entity.Ticket;
import com.grievance.entity.TicketStatus;
import com.grievance.entity.TicketType;

public class TicketTest {
	
	Ticket ticket ;
	
	@BeforeEach
	public void setup() {
		ticket = new Ticket();
		
		ticket.setComments(null);
		ticket.setDepartment(null);
		ticket.setDescription("hello Testing");
		ticket.setEmployee(null);
		ticket.setStatus(TicketStatus.OPEN);
		ticket.setTicketId(1);
		ticket.setTicketName("New ticket");
		ticket.setLastUpdateDate(null);
		ticket.setCreationDate(null);
		ticket.setTicketType(TicketType.FEEDBACK);
	}
	
	@Test
	public void getters_testing_ticket() {
		assertEquals(ticket.getComments(), null);
		assertEquals(ticket.getCreationDate(), null);
		assertEquals(ticket.getEmployee(), null);
		assertEquals(ticket.getDepartment(),null);
		assertEquals(ticket.getLastUpdateDate(), null);
		assertEquals(ticket.getStatus(), TicketStatus.OPEN);
		assertEquals(ticket.getTicketId(), (Integer)1);
		assertEquals(ticket.getTicketName(), "New ticket");
		assertEquals(ticket.getDescription(), "hello Testing");
		assertEquals(ticket.getTicketType(), TicketType.FEEDBACK);
	}
	
}

