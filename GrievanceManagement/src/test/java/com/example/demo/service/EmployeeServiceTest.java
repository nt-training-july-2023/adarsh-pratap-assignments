package com.example.demo.service;

import static org.mockito.Mockito.when;

import com.grievance.dto.EmployeesDto;
import com.grievance.dto.UserLogin;
import com.grievance.entity.Employee;
import com.grievance.entity.Role;
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
    employeeDto.setEmpId(1);
    employeeDto.setUserName("Adarsh");
    employeeDto.setEmail("adarsh@gmail.com");
    employeeDto.setPassword("adarsh");
    employeeDto.setRole(Role.ROLE_ADMIN);
    employeeDto.setDepartment(null);
  }

  /**
   * Testing for Login Api.
   */
  @DisplayName("JUnit test for Login Employee method then returns Welcome ROLE_ADMIN")
  @Test
  public void givenEmployeeObject_whenLoginEmployee_thenReturnString() {
	System.out.println(employee);
	System.out.println(employeeDto);
    UserLogin login = new UserLogin("adarsh@gmail.com", "adarsh");

    when(this.employeeRepo.findByEmail(login.getUserName())).thenReturn(employee);

    Assertions.assertEquals(this.employeeService.login(login), "Welcome ROLE_ADMIN");
  }

  /**
   * Testing for Login Api.
   */
  @DisplayName("JUnit test for Login Employee method Returns Invalid User")
  @Test
  public void givenEmployeeObject_whenLoginEmployee_thenReturnInvalidUser() {
    UserLogin login = new UserLogin("adarsh@gmail.com", "ada");

    when(this.employeeRepo.findByEmail(login.getUserName())).thenReturn(employee);

    Assertions.assertEquals(this.employeeService.login(login), "Invalid User");
  }

  @DisplayName(
    "JUnit test for Login Employee method Returns Invalid User when username is incorrect"
  )
  @Test
  public void givenEmployeeObject_whenLoginEmployee_thenReturnInvalidUserWhenUserNameISIncorrect() {
    UserLogin login = new UserLogin("adar@gmail.com", "adarsh");

    when(this.employeeRepo.findByEmail(login.getUserName())).thenReturn(null);

    Assertions.assertEquals(this.employeeService.login(login), "Invalid User");
  }

  /**
   * Testing for save employee.
   */
  @DisplayName("JUnit test for Save Employee method Returns Employee")
  @Test
  public void givenEmployeeObject_whenSaveEmployee_thenReturnEmployeeForSavingSuccessfully() {
    when(this.modelMapper.map(employee, EmployeesDto.class)).thenReturn(employeeDto);
    when(this.modelMapper.map(employeeDto, Employee.class)).thenReturn(employee);

    when(this.employeeRepo.save(employee)).thenReturn(employee);

    Assertions.assertEquals(this.employeeService.saveEmployee(employeeDto), employeeDto);
  }
}
