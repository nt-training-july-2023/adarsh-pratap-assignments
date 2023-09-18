package com.example.demo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.dto.EmployeeOutDto;
import com.grievance.entity.Role;

public class EmployeeOutDtoTest {
	
	EmployeeOutDto employeeOutDto ;
	
	@BeforeEach
	public void setup() {
		employeeOutDto = new EmployeeOutDto();
		employeeOutDto.setDepartment(null);
		employeeOutDto.setEmail("testing@gmail.com");
		employeeOutDto.setEmpId(1);
		employeeOutDto.setIsFirstLogin(true);
		employeeOutDto.setRole(Role.ROLE_ADMIN);
		employeeOutDto.setUserName("Tester121");
	}
	
	@Test
	public void getter_Testing_EmployeeDto() {
		assertEquals(employeeOutDto.getDepartment(), null);
		assertEquals(employeeOutDto.getEmail(), "testing@gmail.com");
		assertEquals(employeeOutDto.getEmpId(), (Integer)1);
		assertEquals(employeeOutDto.getIsFirstLogin(), true);
		assertEquals(employeeOutDto.getRole(), Role.ROLE_ADMIN);
		assertEquals(employeeOutDto.getUserName(), "Tester121");
	}
	
	@Test
	public void allArgsConstructor_Testing() {
		EmployeeOutDto emp = new EmployeeOutDto(1 , "adarsh" , "adarsh@gmail.com" , Role.ROLE_ADMIN , true , null , null);
	}
	
	@Test
	public void toString_Testing() {
//		System.out.println(employeeOutDto);
		String value = "EmployeeOutDto [empId=1, userName=Tester121, email=testing@gmail.com, role=ROLE_ADMIN, isFirstLogin=true, department=null, ticket=null]";
		assertEquals(employeeOutDto.toString(), value);
	}
	
}

