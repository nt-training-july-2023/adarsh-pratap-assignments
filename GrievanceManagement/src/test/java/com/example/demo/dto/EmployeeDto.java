package com.example.demo.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.dto.EmployeesInDto;
import com.grievance.entity.Role;

public class EmployeeDto {
	
	private EmployeesInDto employeeDto;
	
	@BeforeEach
	  public void setup() {
	    employeeDto =
	      new EmployeesInDto();
	    employeeDto.setUserName("Adarsh");
	    employeeDto.setEmail("adarsh@gmail.com");
	    employeeDto.setPassword("adarsh");
	    employeeDto.setRole(Role.ROLE_ADMIN);
	    employeeDto.setDepartment(null);
	}
	
	@Test
	public void toStringTesting() {
		

		String st = "EmployeesDto [maxPassword=15, minPassword=5, userName=Adarsh, email=adarsh@gmail.com, password=adarsh, role=ROLE_ADMIN, department=null]";
		
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
	
	@Test
	public void hashCodeTest() {
		EmployeesInDto emp = new EmployeesInDto();
		emp.setDepartment(null);
		emp.setEmail("adarsh@gmail.com");
		emp.setPassword("adarsh");
		emp.setRole(Role.ROLE_ADMIN);
		emp.setUserName("Adarsh");
		
		EmployeesInDto emp1 = new EmployeesInDto();
		emp1.setDepartment(null);
		emp1.setEmail("adarsh@gmail.com");
		emp1.setPassword("adarsh");
		emp1.setRole(Role.ROLE_ADMIN);
		emp1.setUserName("Adarsh");
		
		EmployeesInDto emp2 = new EmployeesInDto();
		emp2.setDepartment(null);
		emp2.setEmail("adarsh@gmail.com");
		emp2.setPassword("adarshfksdbfsdvs");
		emp2.setRole(Role.ROLE_ADMIN);
		emp2.setUserName("Adarsh");
		
		assertEquals(emp.hashCode(), emp1.hashCode());
		assertNotEquals(emp.hashCode(), emp2.hashCode());
		
	}
	
	@Test
	public void equalsTest() {
		EmployeesInDto emp = new EmployeesInDto();
		emp.setDepartment(null);
		emp.setEmail("adarsh@gmail.com");
		emp.setPassword("adarsh");
		emp.setRole(Role.ROLE_ADMIN);
		emp.setUserName("Adarsh");
		
		EmployeesInDto emp1 = new EmployeesInDto();
		emp1.setDepartment(null);
		emp1.setEmail("adarsh@gmail.com");
		emp1.setPassword("adarsh");
		emp1.setRole(Role.ROLE_ADMIN);
		emp1.setUserName("Adarsh");
		
		EmployeesInDto emp2 = new EmployeesInDto();
		emp2.setDepartment(null);
		emp2.setEmail("adarsh@gmail.com");
		emp2.setPassword("adarshfksdbfsdvs");
		emp2.setRole(Role.ROLE_ADMIN);
		emp2.setUserName("Adarsh");
		
		assertThat(emp.equals(emp1));
		assertThat(!emp.equals(emp2));
		assertThat(!emp.equals(null));
		assertThat(!emp.equals(new Department()));
		assertThat(emp.equals(emp));
		
	}
}

