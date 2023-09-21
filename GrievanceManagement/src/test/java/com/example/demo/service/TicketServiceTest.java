package com.example.demo.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.grievance.dto.EmployeeOutDto;
import com.grievance.dto.TicketInDto;
import com.grievance.dto.TicketOutDto;
import com.grievance.entity.Department;
import com.grievance.entity.Employee;
import com.grievance.entity.Role;
import com.grievance.entity.Ticket;
import com.grievance.entity.TicketStatus;
import com.grievance.entity.TicketType;
import com.grievance.repo.EmployeeRepo;
import com.grievance.repo.TicketRepo;
import com.grievance.service.EmployeeService;
import com.grievance.service.TicketService;

@ExtendWith(MockitoExtension.class)
public class TicketServiceTest {
  @Mock
  private TicketRepo ticketRepo;

  @InjectMocks
  private TicketService ticketService;

  @Mock
  private ModelMapper modelMapper;

  @Mock
  private EmployeeService employeeService;
  
  private TicketInDto ticketInDto;
  
  private TicketOutDto ticketOutDto;
  
  private Ticket ticket;
  
  @BeforeEach
  public void setup() {
    
    Department dep = new Department(1, "IT", null, null);
    
    Employee emp = new Employee(1 , "Adarsh Singh" , "adarsh@gmail.com" , "adarsh" , Role.ROLE_ADMIN , dep);
    
    Date in = new Date();
    LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
    Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());

    ticket = new Ticket(1,"Laptop problem" , "Having issues" , TicketStatus.OPEN ,out , out, TicketType.GRIEVANCE , dep , emp , null);
    ticketInDto = new TicketInDto("Laptop problem" , "Having issues" , TicketStatus.OPEN , TicketType.GRIEVANCE , dep , emp);
    ticketOutDto = new TicketOutDto(1,"Laptop problem" , "Having issues" , TicketStatus.OPEN ,out , out, TicketType.GRIEVANCE , null , null , null);
  }
  
  @DisplayName("JUnit test for Save Ticket method Returns Ticket")
  @Test
  public void givenEmployeeObject_whenSaveTicket_thenReturnTicketOutDtoForSavingSuccessfully() {
    when(this.modelMapper.map(ticketInDto, Ticket.class)).thenReturn(ticket);
    when(this.modelMapper.map(ticket, TicketOutDto.class)).thenReturn(ticketOutDto);

    when(this.ticketRepo.save(ticket)).thenReturn(ticket);

    Assertions.assertEquals(this.ticketService.addTicket(ticketInDto), ticketOutDto);
  }

//  @Test
//  public void getAllTickets_forAdmin() {
//	List<Ticket> list = new ArrayList<Ticket>();
//	EmployeeOutDto employeeOutDto = new EmployeeOutDto(1 , "Adarsh" , "adarsh@gmail.com" , Role.ROLE_ADMIN, true , null , null);
//
//	Ticket temp = new Ticket(1,"Laptop problem" , "Having issues" , TicketStatus.OPEN ,null , null, TicketType.GRIEVANCE , null , null , null);
//	when(this.employeeService.getById(1)).thenReturn(employeeOutDto);
//	when(this.ticketRepo.findAll()).thenReturn(list);
//
//    Assertions.assertEquals(this.ticketService.findAll(1), list);
//  }
  
//  @Test
//  public void getAllTickets_forUser() {
//	List<Ticket> list = new ArrayList<Ticket>();
//	EmployeeOutDto employeeOutDto = new EmployeeOutDto(1 , "Adarsh" , "adarsh@gmail.com" , Role.ROLE_USER, true , null , null);
//
//	Ticket temp = new Ticket(1,"Laptop problem" , "Having issues" , TicketStatus.OPEN ,null , null, TicketType.GRIEVANCE , null , null , null);
//	when(this.employeeService.getById(1)).thenReturn(employeeOutDto);
//
//    Assertions.assertEquals(this.ticketService.findAll(1), list);
//  }

//  @Test
//  public void updateTickets() {
//	  Optional<Ticket> t = Optional.ofNullable(ticket);
//	  when(this.ticketRepo.findById(1)).thenReturn(t);
//	  when(this.ticketRepo.save(ticket)).thenReturn(ticket);
//	  when(this.modelMapper.map(ticket, TicketOutDto.class)).thenReturn(ticketOutDto);
//	  Assertions.assertEquals(this.ticketService.updateTicket(1, ticketDto),ticketOutDto);
//  }
}
