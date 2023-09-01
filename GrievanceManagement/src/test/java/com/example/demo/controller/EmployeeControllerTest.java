package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.grievance.controller.EmployeeController;
import com.grievance.dto.EmployeesDto;
import com.grievance.dto.UserLogin;
import com.grievance.entity.Employee;
import com.grievance.entity.Role;
import com.grievance.service.EmployeeService;


@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
  
	@Mock
	private EmployeeService employeeService;
	
	@InjectMocks
	private EmployeeController employeeController;
	
	private EmployeesDto employeesDto;
	
	@BeforeEach
	  public void setup() {
//	    employee =
//	      new Employee(1, "Adarsh", "adarsh@gmail.com", "adarsh", Role.ROLE_ADMIN, null);
	    employeesDto =
	      new EmployeesDto(1, "Adarsh", "adarsh@gmail.com", "adarsh", Role.ROLE_ADMIN, null);
	  }
	
	@Test
	public  void givenEmployees_whenSaveEmployees_thenReturnReponseEntity()
			  throws Exception {
		
		
		ResponseEntity<Employee> response = new ResponseEntity(employeesDto , HttpStatus.CREATED);
		 when(this.employeeService.saveEmployee(employeesDto)).thenReturn(employeesDto);
		 
		 ResponseEntity<?> dto = this.employeeController.createEmployee(employeesDto);
//		 dto.status(HttpStatus.CREATED);
		 
		 assertEquals(response,dto );
	}
	
	@Test
	public  void givenEmployees_whenLoginEmployees_thenReturnResponseEntity ()
			  throws Exception {
		
		UserLogin userLogin = new UserLogin("adarsh@gmail.com","adarsh");
		
		ResponseEntity<Employee> response = new ResponseEntity("Welcome ROLE_ADMIN" , HttpStatus.OK);
		 when(this.employeeService.login(userLogin)).thenReturn("Welcome ROLE_ADMIN");
		 
		 ResponseEntity<?> dto = this.employeeController.login(userLogin);
//		 dto.status(HttpStatus.CREATED);
		 
		 assertEquals(response,dto );
	}
	
	@Test
	public  void givenEmployees_whenLoginEmployees_thenReturnResponseEntityStatusUnauthorized ()
			  throws Exception {
		
		UserLogin userLogin = new UserLogin("adarsh@gmail.com","adarsh12345");
		
		ResponseEntity<Employee> response = new ResponseEntity("Invalid User" , HttpStatus.UNAUTHORIZED);
		 when(this.employeeService.login(userLogin)).thenReturn("Invalid User");
		 
		 ResponseEntity<?> dto = this.employeeController.login(userLogin);
//		 dto.status(HttpStatus.CREATED);
		 
		 assertEquals(response,dto );
	}
}
