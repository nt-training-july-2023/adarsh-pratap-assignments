package com.example.demo.dto;

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
		
		TicketOutDtoWithComments tick = new TicketOutDtoWithComments(1, "adarsh","fdsdds",TicketStatus.BEING_ADDRESSED,null,null,TicketType.FEEDBACK,null,null,null);
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
		org.junit.jupiter.api.Assertions.assertEquals(ticket.toString(), "TicketOutDto [ticketId=1, ticketName=evaluation, description=adarsh, status=BEING_ADDRESSED, creationDate=null, lastUpdateDate=null, ticketType=FEEDBACK, department=null, employee=null, comments=null]\r\n"
		+ "");
	}
}

