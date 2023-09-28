package com.example.demo.controller;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grievance.controller.EmployeeController;
import com.grievance.dto.ChangePasswordDto;
import com.grievance.dto.DepartmentInDto;
import com.grievance.dto.DepartmentOutDto;
import com.grievance.dto.EmployeeOutDto;
import com.grievance.dto.EmployeesInDto;
import com.grievance.dto.UserLogin;
import com.grievance.entity.Department;
import com.grievance.entity.Role;
import com.grievance.exception.ApiResponse;
import com.grievance.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Employee Controller Test.
 */
@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
  private EmployeesInDto employeesInDto;

  private EmployeeOutDto employeeOutDto;

  @Mock
  EmployeeService employeeService;

  @InjectMocks
  EmployeeController employeeController;

  private ObjectMapper objectMapper;

  @Autowired
  MockMvc mockMvc;

  /**
   * Set up.
   */
  @BeforeEach
  public void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    objectMapper = new ObjectMapper();
    Department dep = new Department(1, "IT", null, null);

    employeesInDto =
        new EmployeesInDto("Adarsh", "adarsh@nucleusteq.com", "adarsh", Role.ROLE_ADMIN, dep);

    employeeOutDto =
        new EmployeeOutDto(1, "Adarsh", "adarsh@nucleusteq.com", Role.ROLE_ADMIN, true, null, null);
  }

  
  @Test
  void when_login() throws JsonProcessingException, Exception {
    UserLogin login = new UserLogin("adarsh@nucleusteq.com", "adarsh");
    when(employeeService.login(Mockito.any(UserLogin.class))).thenReturn(employeeOutDto);

    mockMvc
      .perform(
        MockMvcRequestBuilders
          .post("/employee/login")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(login))
      )
      .andExpect(status().isOk())
        .andDo(MockMvcResultHandlers.print());
  }

  
  @Test
  public void givenEmployees_whenLoginEmployees_thenReturnReponseEntityAndBadRequest()
      throws JsonProcessingException, Exception {
    UserLogin log = new UserLogin("adarsh@nucleusteq.com", "adarsh");
    when(this.employeeService.login(Mockito.any(UserLogin.class))).thenReturn(null);
    mockMvc
      .perform(
        MockMvcRequestBuilders
          .post("/employee/login")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(log))
      )
      .andExpect(status().isBadRequest())
        .andDo(MockMvcResultHandlers.print());
  }
  
  @Test
  public void givenEmployees_whenSaveEmployees_thenReturnReponseEntity()
      throws JsonProcessingException, Exception {
    when(employeeService.saveEmployee(Mockito.any(EmployeesInDto.class)))
        .thenReturn(employeeOutDto);

    mockMvc
      .perform(
        MockMvcRequestBuilders
          .post("/employee/add")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(employeesInDto))
      )
      .andExpect(status().isCreated())
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void changePassword() throws JsonProcessingException, Exception {
	  ChangePasswordDto changePasswordDto = new ChangePasswordDto("Sachin" , "Sachin123" , "Sachin123");
	  ApiResponse api = new ApiResponse();
	  api.setEntity("Employee");
	  api.setMessage("Password changed Sucessfully!!");
	  when(this.employeeService.changePassword(Mockito.anyInt(), Mockito.any(ChangePasswordDto.class))).thenReturn(api);
	  
	  mockMvc
        .perform(
        MockMvcRequestBuilders
          .put("/employee/changepass/1")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(changePasswordDto))
      )
      .andExpect(status().isOk())
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void changePassword_BadRequest() throws JsonProcessingException, Exception {
	  ChangePasswordDto changePasswordDto = new ChangePasswordDto("Sachin" , "Sachin12" , "Sachin123");
	  ApiResponse api = new ApiResponse();
	  api.setEntity("Employee");
	  api.setMessage("Bad Request");
	  when(this.employeeService.changePassword(Mockito.anyInt(), Mockito.any(ChangePasswordDto.class))).thenReturn(api);
	  
	  mockMvc
        .perform(
        MockMvcRequestBuilders
          .put("/employee/changepass/1")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(changePasswordDto))
      )
      .andExpect(status().isBadRequest())
        .andDo(MockMvcResultHandlers.print());
  }
  
  @Test
  public void UpdateEmployee() throws JsonProcessingException, Exception {
	  
	  when(this.employeeService.updateEmployee(Mockito.anyInt(), Mockito.any(EmployeesInDto.class))).thenReturn(employeeOutDto);
	  
	  
	  mockMvc
        .perform(
        MockMvcRequestBuilders
          .put("/employee/update/1")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(employeesInDto))
      )
      .andExpect(status().isOk())
        .andDo(MockMvcResultHandlers.print());
  }
  
  @Test
  public void getAll() throws JsonProcessingException, Exception {
	  
	  mockMvc
        .perform(
        MockMvcRequestBuilders
          .get("/employee/getall?offset=0")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(employeesInDto))
      )
      .andExpect(status().isOk())
        .andDo(MockMvcResultHandlers.print());
  }
  
  @Test
  public void delete() throws JsonProcessingException, Exception {
	  
	  mockMvc
        .perform(
        MockMvcRequestBuilders
          .delete("/employee/delete/1")
          .contentType(MediaType.APPLICATION_JSON)
      )
      .andExpect(status().isOk())
        .andDo(MockMvcResultHandlers.print());
  }
}
