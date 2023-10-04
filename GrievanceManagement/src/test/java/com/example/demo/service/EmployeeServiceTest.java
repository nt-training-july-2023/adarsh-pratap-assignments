package com.example.demo.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.grievance.dto.ChangePasswordDto;
import com.grievance.dto.EmployeeOutDto;
import com.grievance.dto.EmployeesInDto;
import com.grievance.dto.UserLogin;
import com.grievance.entity.Department;
import com.grievance.entity.Employee;
import com.grievance.entity.Role;
import com.grievance.exception.ApiResponse;
import com.grievance.exception.ResourceNotFound;
import com.grievance.repo.EmployeeRepo;
import com.grievance.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * Employee Service Test.
 */
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
  @Mock
  private EmployeeRepo employeeRepo;

  @InjectMocks
  private EmployeeService employeeService;

  @Mock
  private ModelMapper modelMapper;

  private Employee employee;

  private EmployeesInDto employeeDto;
  
  private EmployeeOutDto employeeOutDto;

  @BeforeEach
  public void setup() {
    employee =
      new Employee();
    employee.setEmpId(1);
    employee.setUserName("Adarsh");
    employee.setEmail("adarsh@gmail.com");
    employee.setPassword("Sachin123");
    employee.setRole(Role.ROLE_ADMIN);
    employee.setDepartment(null);
    
    employeeDto =
      new EmployeesInDto();
    employeeDto.setUserName("Adarsh");
    employeeDto.setEmail("adarsh@gmail.com");
    employeeDto.setPassword("adarsh");
    employeeDto.setRole(Role.ROLE_ADMIN);
    employeeDto.setDepartment(null);
    
    employeeOutDto = new EmployeeOutDto(1 , "Adarsh" , "adarsh@gmail.com" , Role.ROLE_ADMIN , true , null , null);
  }

  /**
   * Testing for Login Api.
   */
  @Test
  public void testLogin1() {
      
      UserLogin login = new UserLogin("adarsh@nucleusteq.com", "123456");
      Department dep = new Department();
      dep.setDepId(1);
      dep.setDepName("IT");
      Employee emp = new Employee();
      emp.setEmail("adarsh@nucleusteq.com");
      emp.setPassword("123456");
      emp.setDepartment(dep);

      when(employeeRepo.findByEmail(login.getUserName())).thenReturn(emp);
      EmployeeOutDto expectedOutput = new EmployeeOutDto();
      when(modelMapper.map(emp, EmployeeOutDto.class)).thenReturn(expectedOutput);
      EmployeeOutDto result = employeeService.login(login);
      assertEquals(expectedOutput, result);
  }

  @Test
  public void testLoginInvalidPassword() {
      UserLogin login = new UserLogin("test@example.com", "wrongpassword");
      Employee mockEmployee = new Employee();
      mockEmployee.setEmail("test@example.com");
      mockEmployee.setPassword("password123");

      when(employeeRepo.findByEmail(login.getUserName())).thenReturn(mockEmployee);

      EmployeeOutDto result = employeeService.login(login);
      assertNull(result);
  }

  @Test
  public void testLoginNoUser() {
	  UserLogin login = new UserLogin("adarsh@nucleusteq.com", "123456");

      when(employeeRepo.findByEmail(login.getUserName())).thenReturn(null);
      EmployeeOutDto result = employeeService.login(login);
      assertEquals(result , null);
  }

  /**
   * Testing for Login Api.
   */
  @DisplayName("JUnit test for Login Employee method Returns Invalid User")
  @Test
  public void givenEmployeeObjectwhenLoginEmployeethenReturnNull() {
    UserLogin login = new UserLogin("adarsh@gmail.com", "ada");
    
    when(this.employeeRepo.findByEmail(login.getUserName())).thenReturn(null);
    
    Assertions.assertEquals(this.employeeService.login(login), null);
  }

  /**
   * Testing for save employee.
   */
  @DisplayName("JUnit test for Save Employee method Returns Employee")
  @Test
  public void givenEmployeeObject_whenSaveEmployee_thenReturnEmployeeForSavingSuccessfully() {
    
    when(this.modelMapper.map(employee, EmployeeOutDto.class)).thenReturn(employeeOutDto);
    when(this.modelMapper.map(employeeDto, Employee.class)).thenReturn(employee);

    when(this.employeeRepo.save(employee)).thenReturn(employee);

    Assertions.assertEquals(this.employeeService.saveEmployee(employeeDto), employeeOutDto);
  }

  @Test
  public void changePassword() {
	  Optional<Employee> emp= Optional.ofNullable(employee);
	  when(this.employeeRepo.findById(1)).thenReturn(emp);
	  ChangePasswordDto changePasswordDto = new ChangePasswordDto("Sachin123" , "Sachin123" , "Sachin123");
	  ApiResponse apiResponse = new ApiResponse();
	  apiResponse.setEntity("Employee");
      apiResponse.setMessage(
          "old password and new password should not be same");
       Assertions.assertEquals(this.employeeService.changePassword(1, changePasswordDto).getMessage(), apiResponse.getMessage());
      
  }
  
  @Test
  public void changePassword_PasswordNotMatch() {
	  Optional<Employee> emp= Optional.ofNullable(employee);
	  when(this.employeeRepo.findById(1)).thenReturn(emp);
	  ChangePasswordDto changePasswordDto = new ChangePasswordDto("Sachin123" , "Sachin1234" , "Sachin12");
	  ApiResponse apiResponse = new ApiResponse();
	  apiResponse.setEntity("Employee");
      apiResponse.setMessage(
          "New password and confirm password should be same");
       Assertions.assertEquals(this.employeeService.changePassword(1, changePasswordDto).getMessage(), apiResponse.getMessage());
      
  }
  
  @Test
  public void changePassword_PasswordChanged() {
	  Optional<Employee> emp= Optional.ofNullable(employee);
	  when(this.employeeRepo.findById(1)).thenReturn(emp);
	  ChangePasswordDto changePasswordDto = new ChangePasswordDto("Sachin123" , "Sachin1234" , "Sachin1234");
	  ApiResponse apiResponse = new ApiResponse();
	  apiResponse.setEntity("Employee");
      apiResponse.setMessage(
          "Password changed Sucessfully!!");
       Assertions.assertEquals(this.employeeService.changePassword(1, changePasswordDto).getMessage(), apiResponse.getMessage());
      
  }

  @Test
  public void whenGetById_ReturnsEmployeeOutDto() {
	  Optional<Employee> emp= Optional.ofNullable(employee);
	  when(this.employeeRepo.findById(1)).thenReturn(emp);
	  lenient().when(this.modelMapper.map(emp.get(), EmployeeOutDto.class)).thenReturn(employeeOutDto);

	  Assertions.assertEquals(employeeOutDto, this.employeeService.getById(1));
  }
  
  @Test
  public void whenChangePassword_ReturnsApiResponse() {
	  employee.setPassword("Sachin23");
	  Optional<Employee> emp= Optional.ofNullable(employee);
	  when(this.employeeRepo.findById(1)).thenReturn(emp);
	  ChangePasswordDto changePasswordDto = new ChangePasswordDto("Sachin23" , "Sachin23" , "Sachin123");
	  ApiResponse apiResponse = new ApiResponse();
	  apiResponse.setEntity("Employee");
      apiResponse.setMessage(
    		  "old password and new password should not be same");
       Assertions.assertEquals(this.employeeService.changePassword(1, changePasswordDto).getMessage(), apiResponse.getMessage());
       
      
  }
  
  
  @Test
  public void whenUpdateEmployee_ReturnsEmployee() {
	  Optional<Employee> emp= Optional.ofNullable(employee);
	  when(this.employeeRepo.findById(1)).thenReturn(emp);
	  when(this.employeeRepo.save(employee)).thenReturn(employee);
	  when(this.modelMapper.map(employee, EmployeeOutDto.class)).thenReturn(employeeOutDto);
       Assertions.assertEquals(employeeOutDto, this.employeeService.updateEmployee(1, employeeDto));
       
      
  }
  
  @Test
  public void getByID() {
	when(this.employeeRepo.findById(1)).thenReturn(Optional.empty());
	
	try {
		this.employeeService.getById(1);
	} catch(ResourceNotFound e) {
		assertEquals("Employee not Found for this Id", e.getMessage());
	}
       
      
  }
  
  @Test
  public void updateEmployeeTest() {
	when(this.employeeRepo.findById(1)).thenReturn(Optional.empty());
	
	try {
		this.employeeService.updateEmployee(1, employeeDto);
	} catch(ResourceNotFound e) {
		assertEquals("Employee Not found", e.getMessage());
	} 
  }
  
  @Test
  public void changePasswordTest() {
	when(this.employeeRepo.findById(1)).thenReturn(Optional.empty());
	
	try {
		this.employeeService.changePassword(1, null);
	} catch(ResourceNotFound e) {
		assertEquals("Employee Not found", e.getMessage());
	} 
  }
  
  @Test
  public void deleteEmp1() {
	when(this.employeeRepo.findById(1)).thenReturn(Optional.empty());
	
	try {
		this.employeeService.deleteEmployee(1);
	} catch(ResourceNotFound e) {
		assertEquals("Employee not found", e.getMessage());
	} 
  }
  
  @Test
  public void deleteEmployee() {
	  Employee emp = new Employee();
	  when(this.employeeRepo.findById(1)).thenReturn(Optional.of(emp));
	  assertEquals("Employee deleted Sucessfully!!", this.employeeService.deleteEmployee(1));
  }
  
  @Test
  public void getAll() {
	  Pageable page = PageRequest.of(1, 10);
	  Page<Employee> emptyPage = new PageImpl<>(new ArrayList<>());
	  when(employeeRepo.findAll(page)).thenReturn(emptyPage);
	  List<EmployeeOutDto> result = employeeService.getAllEmployee(1 , "all");

      assertEquals(0, result.size());
  }
  
}
