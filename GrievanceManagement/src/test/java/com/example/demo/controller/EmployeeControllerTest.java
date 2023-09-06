package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grievance.controller.EmployeeController;
import com.grievance.dto.DepartmentInDto;
import com.grievance.dto.DepartmentOutDto;
import com.grievance.dto.EmployeeOutDto;
import com.grievance.dto.EmployeesDto;
import com.grievance.dto.UserLogin;
import com.grievance.entity.Department;
import com.grievance.entity.Role;
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

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
  private EmployeesDto employeesDto;

  private EmployeeOutDto employeeOutDto;

  @Mock
  EmployeeService employeeService;

  @InjectMocks
  EmployeeController employeeController;

  private ObjectMapper objectMapper;

  @Autowired
  MockMvc mockMvc;

  @BeforeEach
  public void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    objectMapper = new ObjectMapper();
    Department dep = new Department(1, "IT", null, null);

    employeesDto =
      new EmployeesDto("Adarsh", "adarsh@gmail.com", "adarsh", Role.ROLE_ADMIN, dep);

    employeeOutDto =
      new EmployeeOutDto(1, "Adarsh", "adarsh@gmail.com", Role.ROLE_ADMIN, true, null);
  }

  @Test
  void when_login() throws JsonProcessingException, Exception {
    UserLogin login = new UserLogin("adarsh@gmail.com", "adarsh");
    when(employeeService.login(Mockito.any(UserLogin.class))).thenReturn("");

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
    UserLogin login = new UserLogin("adarsh@gmail.com", "adarsh");
    when(employeeService.login(Mockito.any(UserLogin.class))).thenReturn("Invalid User");

    mockMvc
      .perform(
        MockMvcRequestBuilders
          .post("/employee/login")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(login))
      )
      .andExpect(status().isUnauthorized())
      .andDo(MockMvcResultHandlers.print());
  }
  
  @Test
  public void givenEmployees_whenSaveEmployees_thenReturnReponseEntity()
    throws JsonProcessingException, Exception {
    when(employeeService.saveEmployee(Mockito.any(EmployeesDto.class)))
      .thenReturn(employeeOutDto);

    mockMvc
      .perform(
        MockMvcRequestBuilders
          .post("/employee/add")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(employeesDto))
      )
      .andExpect(status().isCreated())
      .andDo(MockMvcResultHandlers.print());
  }

}
