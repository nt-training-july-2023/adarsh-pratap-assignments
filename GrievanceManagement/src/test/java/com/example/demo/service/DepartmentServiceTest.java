package com.example.demo.service;

import com.grievance.dto.DepartmentInDto;
import com.grievance.dto.DepartmentOutDto;
import com.grievance.dto.EmployeeOutDto;
import com.grievance.dto.EmployeesDto;
import com.grievance.entity.Department;
import com.grievance.entity.Employee;
import com.grievance.entity.Role;
import com.grievance.entity.Ticket;
import com.grievance.repo.DepartmentRepo;
import com.grievance.service.DepartmentService;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.ui.Model;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
  @Mock
  private DepartmentRepo departmentRepo;

  @InjectMocks
  private DepartmentService departmentService;

  @Mock
  private ModelMapper modelMapper;

  private Department department;

  private DepartmentInDto departmentInDto;

  private DepartmentOutDto departmentOutDto;

  @BeforeEach
  public void setup() {
    department = new Department(1 , "IT" , null , null);

    departmentInDto = new DepartmentInDto("IT");

    departmentOutDto = new DepartmentOutDto(1 , "IT" , null , null);
  }
  
  @Test
  public void givenDepartmentInDtoObject_whenSaveDepartment_thenReturnDepartmentOutDtoForSavingSuccessfully() {
	  
	  when(this.modelMapper.map(departmentInDto, Department.class)).thenReturn(department);
	  when(this.modelMapper.map(department, DepartmentOutDto.class)).thenReturn(departmentOutDto);
	  when(this.departmentRepo.save(department)).thenReturn(department);

	  Assertions.assertEquals(this.departmentService.addDepartment(departmentInDto), departmentOutDto);
  }
}
