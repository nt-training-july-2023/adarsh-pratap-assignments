package com.example.demo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.dto.DepartmentOutDto;

public class DepartmentOutDtoTest {
	
	DepartmentOutDto dep ;
	
	@BeforeEach
	public void setup() {
		dep = new DepartmentOutDto();
		dep.setDepId(1);
		dep.setDepName("IT");
		dep.setEmployee(null);
		dep.setTicket(null);
	}
	
	@Test
	public void getter_Testing() {
		assertEquals(dep.getDepId(), (Integer)1);
		assertEquals(dep.getDepName(), "IT");
		assertEquals(dep.getEmployee(), null);
		assertEquals(dep.getTicket(), null);
	}
	
	@Test
	public void toString_testing() {
		String value = "DepartmentOutDto [depId=1, depName=IT, employee=null, ticket=null]";
		assertEquals(dep.toString(), value);
	}
}

