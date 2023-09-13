package com.example.demo.service;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.grievance.dto.ChangePasswordDto;
import com.grievance.dto.EmployeeOutDto;
import com.grievance.dto.EmployeesDto;
import com.grievance.dto.UserLogin;
import com.grievance.entity.Employee;
import com.grievance.entity.Role;
import com.grievance.exception.ApiResponse;
import com.grievance.repo.EmployeeRepo;
import com.grievance.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

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

  private EmployeesDto employeeDto;
  
  private EmployeeOutDto employeeOutDto;

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
    
    employeeDto =
      new EmployeesDto();
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
  @DisplayName("JUnit test for Login Employee method then returns Welcome ROLE_ADMIN")
  @Test
  public void givenEmployeeObject_whenLoginEmployee_thenReturnEmployeeOutDto() {

    UserLogin login = new UserLogin("adarsh@gmail.com", "adarsh");
    
    when(this.modelMapper.map(employee, EmployeeOutDto.class)).thenReturn(employeeOutDto);

    when(this.employeeRepo.findByEmail(login.getUserName())).thenReturn(employee);

    Assertions.assertEquals(this.employeeService.login(login), employeeOutDto);
  }

  /**
   * Testing for Login Api.
   */
  @DisplayName("JUnit test for Login Employee method Returns Invalid User")
  @Test
  public void givenEmployeeObject_whenLoginEmployee_thenReturnNull() {
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
	  ChangePasswordDto changePasswordDto = new ChangePasswordDto("Sachin23" , "Sachin123" , "Sachin12");
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
	  ChangePasswordDto changePasswordDto = new ChangePasswordDto("Sachin23" , "Sachin123" , "Sachin123");
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
}
