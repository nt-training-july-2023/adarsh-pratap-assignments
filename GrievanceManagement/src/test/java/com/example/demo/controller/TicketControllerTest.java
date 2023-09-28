package com.example.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grievance.controller.EmployeeController;
import com.grievance.controller.TicketController;
import com.grievance.dto.EmployeeOutDto;
import com.grievance.dto.EmployeesInDto;
import com.grievance.dto.TicketInDto;
import com.grievance.dto.TicketOutDto;
import com.grievance.entity.Department;
import com.grievance.entity.Employee;
import com.grievance.entity.Role;
import com.grievance.entity.TicketStatus;
import com.grievance.entity.TicketType;
import com.grievance.service.EmployeeService;
import com.grievance.service.TicketService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

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
public class TicketControllerTest {
  private TicketInDto ticketInDto;

  private TicketOutDto ticketOutDto;

  @Mock
  TicketService ticketService;

  @InjectMocks
  TicketController ticketController;

  private ObjectMapper objectMapper;

  @Autowired
  MockMvc mockMvc;

  @BeforeEach
  public void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(ticketController).build();
    objectMapper = new ObjectMapper();
    Department dep = new Department(1, "IT", null, null);
    
    Employee emp = new Employee(1 , "Adarsh Singh" , "adarsh@gmail.com" , "adarsh" , Role.ROLE_ADMIN , dep);
    
    Date in = new Date();
    LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
    Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());

    ticketOutDto = new TicketOutDto();
    ticketInDto = new TicketInDto("Laptop problem" , "Having issues" , TicketStatus.OPEN , TicketType.GRIEVANCE , dep , emp);
    ticketInDto = new TicketInDto("Laptop problem" , "Having issues" , TicketStatus.OPEN , TicketType.GRIEVANCE , dep , emp);
    ticketOutDto.setTicketId(1);
    ticketOutDto.setTicketName("Laptop problem");
    ticketOutDto.setDescription("Having issues");
    ticketOutDto.setStatus(TicketStatus.OPEN);
    ticketOutDto.setCreationDate(out);
    ticketOutDto.setLastUpdateDate(out);
    ticketOutDto.setTicketType(TicketType.GRIEVANCE);
    ticketOutDto.setDepartment(null);
    ticketOutDto.setEmployee(null);
    ticketOutDto.setComments(null);
  }
  
  @Test
  public void givenTicket_WhenSave_ReturnTicket() throws JsonProcessingException, Exception {
	  
	  when(ticketService.addTicket(Mockito.any(TicketInDto.class)))
      .thenReturn(ticketOutDto);

    mockMvc
      .perform(
        MockMvcRequestBuilders
          .post("/ticket/add")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(ticketInDto))
      )
      .andExpect(status().isCreated())
      .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void givenTicket_whenUpdate_ReturnUpdateTicketOutDto() throws JsonProcessingException, Exception {
//	  when(ticketService.updateTicket(1 , ticketDto))
//      .thenReturn(ticketOutDto);
	  
	  mockMvc
      .perform(
        MockMvcRequestBuilders
          .put("/ticket/update/1")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(ticketInDto))
      )
      .andExpect(status().isOk())
      .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void listOfAllTickets() throws JsonProcessingException, Exception {

	  mockMvc
      .perform(
        MockMvcRequestBuilders
          .get("/ticket/getall/?empid=19&ticket=all&filter=open&offset=0")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(null))
      )
      .andExpect(status().isOk())
      .andDo(MockMvcResultHandlers.print());
  }
  
  @Test
  public void getallTikcets() throws JsonProcessingException, Exception {

//	  when(ticketService.findAll(Mockito.anyInt(),Mockito.any(String.class),Mockito.any(String.class) , Mockito.anyInt()))
//      .thenReturn(Mockito.anyList());

	  mockMvc
      .perform(
        MockMvcRequestBuilders
          .get("/ticket/getall/?empid=19&ticket=all&filter=open&offset=0")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(null))
      )
      .andExpect(status().isOk())
      .andDo(MockMvcResultHandlers.print());
  }
  
  @Test
  public void getTicketById() throws JsonProcessingException, Exception {

	  mockMvc
      .perform(
        MockMvcRequestBuilders
          .get("/ticket/get/1")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(null))
      )
      .andExpect(status().isOk())
      .andDo(MockMvcResultHandlers.print());
  }
}
