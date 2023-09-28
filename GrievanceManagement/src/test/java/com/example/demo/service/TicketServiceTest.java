package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;
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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.grievance.dto.EmployeeOutDto;
import com.grievance.dto.TicketInDto;
import com.grievance.dto.TicketOutDto;
import com.grievance.dto.TicketOutDtoWithComments;
import com.grievance.dto.UpdateTicketInDto;
import com.grievance.entity.Comment;
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

    ticket = new Ticket();
    ticket.setTicketId(1);
    ticket.setTicketName("Laptop problem");
    ticket.setDescription("Having issues");
    ticket.setStatus(TicketStatus.OPEN);
    ticket.setCreationDate(out);
    ticket.setLastUpdateDate(out);
    ticket.setTicketType(TicketType.GRIEVANCE);
    ticket.setDepartment(dep);
    ticket.setEmployee(emp);
    ticket.setComments(null);
    
    ticketOutDto = new TicketOutDto();
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
  
  @DisplayName("JUnit test for Save Ticket method Returns Ticket")
  @Test
  public void givenEmployeeObject_whenSaveTicket_thenReturnTicketOutDtoForSavingSuccessfully() {
    when(this.modelMapper.map(ticketInDto, Ticket.class)).thenReturn(ticket);
    when(this.modelMapper.map(ticket, TicketOutDto.class)).thenReturn(ticketOutDto);

    when(this.ticketRepo.save(ticket)).thenReturn(ticket);

    Assertions.assertEquals(this.ticketService.addTicket(ticketInDto), ticketOutDto);
  }

  @Test
  public void updateTickets() {
	  UpdateTicketInDto updateTicketInDto = new UpdateTicketInDto();
	  updateTicketInDto.setStatus(TicketStatus.OPEN);
	  updateTicketInDto.setComment("");
	  updateTicketInDto.setEmpName("Adarsh");
	  Optional<Ticket> t = Optional.ofNullable(ticket);
	  when(this.ticketRepo.findById(1)).thenReturn(t);
	  when(this.ticketRepo.save(ticket)).thenReturn(ticket);
	  when(this.modelMapper.map(ticket, TicketOutDtoWithComments.class)).thenReturn(null);
	  Assertions.assertEquals(this.ticketService.updateTicket(1, updateTicketInDto),null);
  }
  
  @Test
  public void getTicketbyId() {
	  
	  Optional<Ticket> t = Optional.ofNullable(ticket);
	  when(this.ticketRepo.findById(1)).thenReturn(t);
	  
	  when(this.modelMapper.map(ticket, TicketOutDtoWithComments.class)).thenReturn(null);
	  Assertions.assertEquals(this.ticketService.ticketById(1),null);
  }
  
  @Test
  public void testTicketForAdmin_AllTypeMyFilterAll() {
      String filter = "all";
      String type = "my";
      EmployeeOutDto emp = new EmployeeOutDto();
      Integer offset = 0;

      Pageable page = PageRequest.of(offset, 10, Sort.by("status"));
      when(modelMapper.map(any(), eq(Department.class))).thenReturn(new Department());
      when(modelMapper.map(any(), eq(Employee.class))).thenReturn(new Employee());      
      List<Ticket> ticketList = new ArrayList<>();
      when(ticketRepo.findByEmployee(any(), eq(page))).thenReturn(new PageImpl<>(ticketList));

      
      Page<Ticket> result = ticketService.ticketForAdmin(filter, type, emp, offset);

      
      assertEquals(ticketList, result.getContent());
      
  }
  
 

  @Test
  public void testFindAll_AdminRole() {
      Integer id = 1;
      String type = "my";
      String filter = "open";
      Integer offset = 0;

      EmployeeOutDto adminEmp = new EmployeeOutDto();
      adminEmp.setRole(Role.ROLE_ADMIN);

      Page<Ticket> mockTicketPage = new PageImpl<>(new ArrayList<>());
      when(employeeService.getById(id)).thenReturn(adminEmp);
      when(ticketService.ticketForAdmin(filter, type, adminEmp, offset)).thenReturn(mockTicketPage);

      List<TicketOutDto> result = ticketService.findAll(id, type, filter, offset);

      assertEquals(0, result.size());
      
  }
  
  @Test
  public void testFindAll_UserRole() {
      Integer id = 2;
      String type = "my";
      String filter = "open";
      Integer offset = 0;

      EmployeeOutDto userEmp = new EmployeeOutDto();
      userEmp.setRole(Role.ROLE_USER);

      Page<Ticket> ticketPage = new PageImpl<>(new ArrayList<>());
      when(employeeService.getById(id)).thenReturn(userEmp);
      when(ticketService.ticketForUser(filter, type, userEmp, offset)).thenReturn(ticketPage);

      List<TicketOutDto> result = ticketService.findAll(id, type, filter, offset);

      assertEquals(0, result.size());
     
  }
}
