package com.example.demo.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
		employeeOutDto.setTicket(null);
	}
	
	@Test
	public void getter_Testing_EmployeeDto() {
		assertEquals(employeeOutDto.getDepartment(), null);
		assertEquals(employeeOutDto.getEmail(), "testing@gmail.com");
		assertEquals(employeeOutDto.getEmpId(), (Integer)1);
		assertEquals(employeeOutDto.getIsFirstLogin(), true);
		assertEquals(employeeOutDto.getRole(), Role.ROLE_ADMIN);
		assertEquals(employeeOutDto.getUserName(), "Tester121");
		assertEquals(employeeOutDto.getTicket(), null);
	}
	
	@Test
	public void allArgsConstructor_Testing() {
		EmployeeOutDto emp = new EmployeeOutDto(1 , "adarsh" , "adarsh@gmail.com" , Role.ROLE_ADMIN , true , null , null);
	}
	
	@Test
	public void toString_Testing() {
		String value = "EmployeeOutDto [empId=1, userName=Tester121, email=testing@gmail.com, role=ROLE_ADMIN, isFirstLogin=true, department=null, ticket=null]";
		assertEquals(employeeOutDto.toString(), value);
	}
	
	@Test
	public void hashCodeTest() {
		EmployeeOutDto emp1 = new EmployeeOutDto();
		emp1.setDepartment(null);
		emp1.setDepName("IT");
		emp1.setEmail("adarsh@gmail.com");
		emp1.setEmpId(1);
		emp1.setIsFirstLogin(true);
		emp1.setRole(Role.ROLE_ADMIN);
		emp1.setTicket(null);
		emp1.setUserName("Adarsh");
		
		EmployeeOutDto emp2 = new EmployeeOutDto();
		emp2.setDepartment(null);
		emp2.setDepName("IT");
		emp2.setEmail("adarsh@gmail.com");
		emp2.setEmpId(1);
		emp2.setIsFirstLogin(true);
		emp2.setRole(Role.ROLE_ADMIN);
		emp2.setTicket(null);
		emp2.setUserName("Adarsh");
		
		EmployeeOutDto emp3 = new EmployeeOutDto();
		emp3.setDepartment(null);
		emp3.setDepName("Ikajdbfs");
		emp3.setEmail("adarsh@gmail.com");
		emp3.setEmpId(1);
		emp3.setIsFirstLogin(true);
		emp3.setRole(Role.ROLE_ADMIN);
		emp3.setTicket(null);
		emp3.setUserName("Adarsh");
		
		
		assertEquals(emp1.hashCode(), emp2.hashCode());
		assertNotEquals(emp1.hashCode(), emp3.hashCode());
  }
	
@Test
public void equalsMethodTesting() {
	EmployeeOutDto emp1 = new EmployeeOutDto();
	emp1.setDepartment(null);
	emp1.setDepName("IT");
	emp1.setEmail("adarsh@gmail.com");
	emp1.setEmpId(1);
	emp1.setIsFirstLogin(true);
	emp1.setRole(Role.ROLE_ADMIN);
	emp1.setTicket(null);
	emp1.setUserName("Adarsh");
	
	EmployeeOutDto emp2 = new EmployeeOutDto();
	emp2.setDepartment(null);
	emp2.setDepName("IT");
	emp2.setEmail("adarsh@gmail.com");
	emp2.setEmpId(1);
	emp2.setIsFirstLogin(true);
	emp2.setRole(Role.ROLE_ADMIN);
	emp2.setTicket(null);
	emp2.setUserName("Adarsh");

	EmployeeOutDto emp3 = new EmployeeOutDto();
	emp3.setDepartment(null);
	emp3.setDepName("Ikajdbfs");
	emp3.setEmail("adarsh@gmail.com");
	emp3.setEmpId(1);
	emp3.setIsFirstLogin(true);
	emp3.setRole(Role.ROLE_ADMIN);
	emp3.setTicket(null);
	emp3.setUserName("Adarsh");

	assertThat(emp1.equals(emp2));
	assertThat(!emp1.equals(emp3));
	assertThat(!emp1.equals(null));
	assertThat(!emp1.equals(new Department()));
	assertThat(emp1.equals(emp1));
  }
}

