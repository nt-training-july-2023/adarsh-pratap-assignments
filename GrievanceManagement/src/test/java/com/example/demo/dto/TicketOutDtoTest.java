package com.example.demo.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.dto.DepartmentOutDto;
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
		ticket.setDepName("IT");
		ticket.setEmpName("Adarsh");
	}
	
	@Test
	public void getters_Testing() {
		assertEquals(ticket.getDepName(), "IT");
		assertEquals(ticket.getEmpName(), "Adarsh");
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
	
	@Test
	public void TestHashCode() {
		TicketOutDto tick1 = new TicketOutDto();
		tick1.setDepName("IT");
		tick1.setDepartment(null);
		tick1.setDescription("dep");
		tick1.setEmpName("adarsh");
		tick1.setStatus(TicketStatus.BEING_ADDRESSED);
		tick1.setTicketId(1);
		tick1.setTicketName("ticket");
		tick1.setTicketType(TicketType.FEEDBACK);
		
		TicketOutDto tick2 = new TicketOutDto();
		tick2.setDepName("IT");
		tick2.setDepartment(null);
		tick2.setDescription("dep");
		tick2.setEmpName("adarsh");
		tick2.setStatus(TicketStatus.BEING_ADDRESSED);
		tick2.setTicketId(1);
		tick2.setTicketName("ticket");
		tick2.setTicketType(TicketType.FEEDBACK);
		
		TicketOutDto tick3 = new TicketOutDto();
		tick3.setDepName("IT");
		tick3.setDepartment(null);
		tick3.setDescription("dep");
		tick3.setEmpName("adarsh");
		tick3.setStatus(TicketStatus.BEING_ADDRESSED);
		tick3.setTicketId(1);
		tick3.setTicketName("tic");
		tick3.setTicketType(TicketType.FEEDBACK);
		
		assertEquals(tick1.hashCode(), tick2.hashCode());
		assertNotEquals(tick1.hashCode(), tick3.hashCode());
	}
	
	@Test
	public void TicketEquals() {
		TicketOutDto tick1 = new TicketOutDto();
		tick1.setDepName("IT");
		tick1.setDepartment(null);
		tick1.setDescription("dep");
		tick1.setEmpName("adarsh");
		tick1.setStatus(TicketStatus.BEING_ADDRESSED);
		tick1.setTicketId(1);
		tick1.setTicketName("ticket");
		tick1.setTicketType(TicketType.FEEDBACK);
		
		TicketOutDto tick2 = new TicketOutDto();
		tick2.setDepName("IT");
		tick2.setDepartment(null);
		tick2.setDescription("dep");
		tick2.setEmpName("adarsh");
		tick2.setStatus(TicketStatus.BEING_ADDRESSED);
		tick2.setTicketId(1);
		tick2.setTicketName("ticket");
		tick2.setTicketType(TicketType.FEEDBACK);
		
		TicketOutDto tick3 = new TicketOutDto();
		tick3.setDepName("sdfsfsd");
		tick3.setDepartment(new DepartmentOutDto());
		tick3.setDescription("dsfs");
		tick3.setEmpName("adarsdfsdf");
		tick3.setStatus(TicketStatus.OPEN);
		tick3.setTicketId(3);
		tick3.setTicketName("ticcsdsdcs");
		tick3.setTicketType(TicketType.GRIEVANCE);
		
	    assertThat(tick1.equals(tick2));
	    assertThat(!tick1.equals(tick3));
	    assertThat(tick1.equals(tick1));
	    assertThat(tick1.equals(null));
	    assertThat(tick1.equals(new Department()));
	}
	
}

