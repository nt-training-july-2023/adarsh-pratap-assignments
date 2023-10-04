package com.example.demo.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.dto.TicketOutDtoWithComments;
import com.grievance.entity.TicketStatus;
import com.grievance.entity.TicketType;

public class TicketOutDtoWithCommentsTest {
	
	TicketOutDtoWithComments ticket;
	
	@BeforeEach
	void setup() {
		ticket = new TicketOutDtoWithComments();
		ticket.setComments(null);
		ticket.setCreationDate(null);
		ticket.setDepartment(null);
		ticket.setDescription("adarsh");
		ticket.setEmployee(null);
		ticket.setLastUpdateDate(null);
		ticket.setStatus(TicketStatus.BEING_ADDRESSED);
		ticket.setTicketId(1);
		ticket.setTicketName("evaluation");
		ticket.setTicketType(TicketType.FEEDBACK);
			
	}
	
	@Test
	void getter_setter() {
		org.junit.jupiter.api.Assertions.assertEquals(ticket.getTicketId(), 1);
		org.junit.jupiter.api.Assertions.assertEquals(ticket.getDescription(), "adarsh");
		org.junit.jupiter.api.Assertions.assertEquals(ticket.getTicketName(), "evaluation");
		org.junit.jupiter.api.Assertions.assertEquals(ticket.getComments(), null);
		org.junit.jupiter.api.Assertions.assertEquals(ticket.getCreationDate(), null);
		org.junit.jupiter.api.Assertions.assertEquals(ticket.getDepartment(), null);
		org.junit.jupiter.api.Assertions.assertEquals(ticket.getEmployee(), null);
		org.junit.jupiter.api.Assertions.assertEquals(ticket.getLastUpdateDate(), null);
		org.junit.jupiter.api.Assertions.assertEquals(ticket.getStatus(), TicketStatus.BEING_ADDRESSED);
		org.junit.jupiter.api.Assertions.assertEquals(ticket.getTicketType(), TicketType.FEEDBACK);
		System.out.println(ticket);
		org.junit.jupiter.api.Assertions.assertEquals(ticket.toString(), "TicketOutDto [ticketId=1, ticketName=evaluation, description=adarsh, status=BEING_ADDRESSED, creationDate=null, lastUpdateDate=null, ticketType=FEEDBACK, department=null, employee=null, comments=null]");
	}
	
	@Test
	public void TicketHashCode() {
		TicketOutDtoWithComments ticket1 = new TicketOutDtoWithComments();
		ticket1 = new TicketOutDtoWithComments();
		ticket1.setComments(null);
		ticket1.setCreationDate(null);
		ticket1.setDepartment(null);
		ticket1.setDescription("adarsh");
		ticket1.setEmployee(null);
		ticket1.setLastUpdateDate(null);
		ticket1.setStatus(TicketStatus.BEING_ADDRESSED);
		ticket1.setTicketId(1);
		ticket1.setTicketName("evaluation");
		ticket1.setTicketType(TicketType.FEEDBACK);
		
		TicketOutDtoWithComments ticket2 = new TicketOutDtoWithComments();
		ticket2 = new TicketOutDtoWithComments();
		ticket2.setComments(null);
		ticket2.setCreationDate(null);
		ticket2.setDepartment(null);
		ticket2.setDescription("adarsh");
		ticket2.setEmployee(null);
		ticket2.setLastUpdateDate(null);
		ticket2.setStatus(TicketStatus.BEING_ADDRESSED);
		ticket2.setTicketId(1);
		ticket2.setTicketName("evaluation");
		ticket2.setTicketType(TicketType.FEEDBACK);
		
		TicketOutDtoWithComments ticket3 = new TicketOutDtoWithComments();
		ticket3 = new TicketOutDtoWithComments();
		ticket3.setComments(null);
		ticket3.setCreationDate(null);
		ticket3.setDepartment(null);
		ticket3.setDescription("ada");
		ticket3.setEmployee(null);
		ticket3.setLastUpdateDate(null);
		ticket3.setStatus(TicketStatus.BEING_ADDRESSED);
		ticket3.setTicketId(1);
		ticket3.setTicketName("evaluation");
		ticket3.setTicketType(TicketType.FEEDBACK);
		
		assertEquals(ticket1.hashCode(), ticket2.hashCode());
		assertNotEquals(ticket1.hashCode(), ticket3.hashCode());
	}
	
	@Test
	public void TicketEqualMethod() {
		TicketOutDtoWithComments ticket1 = new TicketOutDtoWithComments();
		ticket1 = new TicketOutDtoWithComments();
		ticket1.setComments(null);
		ticket1.setCreationDate(null);
		ticket1.setDepartment(null);
		ticket1.setDescription("adarsh");
		ticket1.setEmployee(null);
		ticket1.setLastUpdateDate(null);
		ticket1.setStatus(TicketStatus.BEING_ADDRESSED);
		ticket1.setTicketId(1);
		ticket1.setTicketName("evaluation");
		ticket1.setTicketType(TicketType.FEEDBACK);
		
		TicketOutDtoWithComments ticket2 = new TicketOutDtoWithComments();
		ticket2 = new TicketOutDtoWithComments();
		ticket2.setComments(null);
		ticket2.setCreationDate(null);
		ticket2.setDepartment(null);
		ticket2.setDescription("adarsh");
		ticket2.setEmployee(null);
		ticket2.setLastUpdateDate(null);
		ticket2.setStatus(TicketStatus.BEING_ADDRESSED);
		ticket2.setTicketId(1);
		ticket2.setTicketName("evaluation");
		ticket2.setTicketType(TicketType.FEEDBACK);
		
		TicketOutDtoWithComments ticket3 = new TicketOutDtoWithComments();
		ticket3 = new TicketOutDtoWithComments();
		ticket3.setComments(null);
		ticket3.setCreationDate(null);
		ticket3.setDepartment(null);
		ticket3.setDescription("ada");
		ticket3.setEmployee(null);
		ticket3.setLastUpdateDate(null);
		ticket3.setStatus(TicketStatus.BEING_ADDRESSED);
		ticket3.setTicketId(1);
		ticket3.setTicketName("evaluation");
		ticket3.setTicketType(TicketType.FEEDBACK);
		
		assertThat(ticket1.equals(ticket2));
		assertThat(!ticket1.equals(ticket3));
	}
}

