package com.example.demo.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
	
	@Test
	public void hashCodeTest() {
	  DepartmentOutDto dep = new DepartmentOutDto();
	  dep.setDepId(1);
	  dep.setDepName("IT");
	  dep.setEmployee(null);
	  dep.setTicket(null);
	  
	  DepartmentOutDto dep1 = new DepartmentOutDto();
	  dep1.setDepId(1);
	  dep1.setDepName("IT");
	  dep1.setEmployee(null);
	  dep1.setTicket(null);
	  
	  DepartmentOutDto dep2 = new DepartmentOutDto();
	  dep2.setDepId(1);
	  dep2.setDepName("HR");
	  dep2.setEmployee(null);
	  dep2.setTicket(null);
	  
	  assertEquals(dep.hashCode(), dep1.hashCode());
	  assertNotEquals(dep.hashCode(), dep2.hashCode());
	}
	
	@Test
	public void equalsTest() {
		DepartmentOutDto dep = new DepartmentOutDto();
		  dep.setDepId(1);
		  dep.setDepName("IT");
		  dep.setEmployee(null);
		  dep.setTicket(null);
		  
		  DepartmentOutDto dep1 = new DepartmentOutDto();
		  dep1.setDepId(1);
		  dep1.setDepName("IT");
		  dep1.setEmployee(null);
		  dep1.setTicket(null);
		  
		  DepartmentOutDto dep2 = new DepartmentOutDto();
		  dep2.setDepId(1);
		  dep2.setDepName("HR");
		  dep2.setEmployee(null);
		  dep2.setTicket(null);
		  
		  assertThat(dep.equals(dep1));
		  assertThat(!dep.equals(dep2));
		  assertThat(!dep.equals(null));
		  assertThat(!dep.equals(new Department()));
		  assertThat(dep.equals(dep));
	}
}

