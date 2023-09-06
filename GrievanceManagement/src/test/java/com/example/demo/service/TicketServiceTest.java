package com.example.demo.service;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.grievance.dto.TicketDto;
import com.grievance.dto.TicketOutDto;
import com.grievance.entity.Department;
import com.grievance.entity.Employee;
import com.grievance.entity.Role;
import com.grievance.entity.Ticket;
import com.grievance.entity.TicketStatus;
import com.grievance.entity.TicketType;
import com.grievance.repo.TicketRepo;
import com.grievance.service.TicketService;

@ExtendWith(MockitoExtension.class)
public class TicketServiceTest {
  @Mock
  private TicketRepo ticketRepo;

  @InjectMocks
  private TicketService ticketService;

  @Mock
  private ModelMapper modelMapper;
  
  private TicketDto ticketDto;
  
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
    ticketDto = new TicketDto("Laptop problem" , "Having issues" , TicketStatus.OPEN , TicketType.GRIEVANCE , dep , emp);
    ticketOutDto = new TicketOutDto(1,"Laptop problem" , "Having issues" , TicketStatus.OPEN ,out , out, TicketType.GRIEVANCE , dep , emp , null);
  }
  
  @DisplayName("JUnit test for Save Ticket method Returns Ticket")
  @Test
  public void givenEmployeeObject_whenSaveTicket_thenReturnTicketOutDtoForSavingSuccessfully() {
    when(this.modelMapper.map(ticketDto, Ticket.class)).thenReturn(ticket);
    when(this.modelMapper.map(ticket, TicketOutDto.class)).thenReturn(ticketOutDto);

    when(this.ticketRepo.save(ticket)).thenReturn(ticket);

    Assertions.assertEquals(this.ticketService.addTicket(ticketDto), ticketOutDto);
  }
}
