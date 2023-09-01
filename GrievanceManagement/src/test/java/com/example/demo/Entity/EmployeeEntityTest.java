package com.example.demo.Entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.grievance.entity.Employee;
import com.grievance.entity.Role;

@SpringBootTest
public class EmployeeEntityTest {
	
	private Employee employee;
	
	@BeforeEach
	  public void setup() {
	    employee =
	      new Employee();
	    employee.setEmpId(1);
	    employee.setUserName("Adarsh");
	    employee.setEmail("adarsh@gmail.com");
	    employee.setPassword("adarsh");
	    employee.setRole(Role.ROLE_ADMIN);
	    employee.setDepartment(null);
	}
	
	@Test
	public void toStringTesting() {
		
		System.out.println(employee);
		String st = "Employees [empId=1, userName=Adarsh, email=adarsh@gmail.com, password=adarsh, role=ROLE_ADMIN, department=null]";
		
		assertEquals(st, employee.toString());
	}
	
}

