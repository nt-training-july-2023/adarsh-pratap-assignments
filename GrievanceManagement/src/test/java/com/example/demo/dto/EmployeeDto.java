package com.example.demo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.dto.EmployeesDto;
import com.grievance.entity.Role;

public class EmployeeDto {
	
	private EmployeesDto employeeDto;
	
	@BeforeEach
	  public void setup() {
	    employeeDto =
	      new EmployeesDto();
	    employeeDto.setUserName("Adarsh");
	    employeeDto.setEmail("adarsh@gmail.com");
	    employeeDto.setPassword("adarsh");
	    employeeDto.setRole(Role.ROLE_ADMIN);
	    employeeDto.setDepartment(null);
	}
	
	@Test
	public void toStringTesting() {
		

		String st = "EmployeesDto [empId=1, userName=Adarsh, email=adarsh@gmail.com, password=adarsh, role=ROLE_ADMIN, department=null]";
		
		assertEquals(st, employeeDto.toString());
	}
	
	@Test
	public void getter() {
		
		System.out.println(employeeDto.getRole());
		
		
		assertEquals("Adarsh",employeeDto.getUserName());
		assertEquals("adarsh@gmail.com",employeeDto.getEmail());
		assertEquals("adarsh" , employeeDto.getPassword());
		assertEquals(Role.ROLE_ADMIN , employeeDto.getRole() );
		assertEquals( null , employeeDto.getDepartment());
	}
}

