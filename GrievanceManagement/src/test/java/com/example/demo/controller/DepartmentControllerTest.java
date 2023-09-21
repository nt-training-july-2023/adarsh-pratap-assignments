package com.example.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grievance.controller.DepartmentController;
import com.grievance.controller.EmployeeController;
import com.grievance.dto.DepartmentInDto;
import com.grievance.dto.DepartmentOutDto;
import com.grievance.dto.EmployeeOutDto;
import com.grievance.dto.EmployeesInDto;
import com.grievance.dto.TicketInDto;
import com.grievance.dto.UserLogin;
import com.grievance.entity.Department;
import com.grievance.entity.Role;
import com.grievance.service.DepartmentService;
import com.grievance.service.EmployeeService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

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
public class DepartmentControllerTest {
  private DepartmentInDto departmentInDto;

  private DepartmentOutDto departmentOutDto;

  @Mock
  private DepartmentService departmentService;

  @InjectMocks
  private DepartmentController departmentController;

  private ObjectMapper objectMapper;

  @Autowired
  MockMvc mockMvc;

  @BeforeEach
  public void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(departmentController).build();
    objectMapper = new ObjectMapper();
    departmentInDto = new DepartmentInDto("IT");

    departmentOutDto = new DepartmentOutDto(1 , "IT" , null , null);
  }
  
  @Test
  public void givenEmployees_whenSaveEmployees_thenReturnReponseEntity()
    throws JsonProcessingException, Exception {
    when(departmentService.addDepartment(Mockito.any(DepartmentInDto.class)))
      .thenReturn(departmentOutDto);

    mockMvc
      .perform(
        MockMvcRequestBuilders
          .post("/department/add")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(departmentInDto))
      )
      .andExpect(status().isCreated())
      .andDo(MockMvcResultHandlers.print());
  }
  
  @Test
  public void givenEmployee_whenGetAllEmployee_thenReturnListOfDepartment() throws JsonProcessingException, Exception {

    when(this.departmentService.getAllDepartment()).thenReturn(null);

    mockMvc
    .perform(
    MockMvcRequestBuilders
    .get("/department/getall")
    .contentType(MediaType.APPLICATION_JSON)
    .content(objectMapper.writeValueAsString(null))
    )
    .andExpect(status().isOk())
	.andDo(MockMvcResultHandlers.print());
  }
}
