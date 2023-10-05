package com.example.demo.service;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.grievance.dto.DepartmentInDto;
import com.grievance.dto.DepartmentOutDto;
import com.grievance.dto.EmployeeOutDto;
import com.grievance.dto.EmployeesInDto;
import com.grievance.entity.Department;
import com.grievance.entity.Employee;
import com.grievance.entity.Role;
import com.grievance.entity.Ticket;
import com.grievance.exception.ResourceNotFound;
import com.grievance.repo.DepartmentRepo;
import com.grievance.service.DepartmentService;
import com.jayway.jsonpath.Option;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
    department = new Department(1, "IT", null, null);

    departmentInDto = new DepartmentInDto("IT");

    departmentOutDto = new DepartmentOutDto(1, "IT", null, null);
  }

  @Test
  public void givenDepartmentInDtoObject_whenSaveDepartment_thenReturnDepartmentOutDtoForSavingSuccessfully() {
    when(this.modelMapper.map(departmentInDto, Department.class)).thenReturn(department);
    when(this.modelMapper.map(department, DepartmentOutDto.class))
      .thenReturn(departmentOutDto);
    when(this.departmentRepo.save(department)).thenReturn(department);

    Assertions.assertEquals(
      this.departmentService.addDepartment(departmentInDto),
      departmentOutDto
    );
  }
  
  @Test
  public void whenGetAllDepartment_thenReturnListOfDepartment() {
	  List<Department> dep = new ArrayList<Department>();
      dep.add(department);
      
      List<DepartmentOutDto> depOut = new ArrayList<DepartmentOutDto>();
      depOut.add(departmentOutDto);
	  when(this.modelMapper.map(department, DepartmentOutDto.class))
	    .thenReturn(departmentOutDto);
	  when(this.departmentRepo.findAll()).thenReturn(dep);
	  
	  Assertions.assertEquals(this.departmentService.getAllDepartment(),depOut);
  }
  
  @Test
  public void whenDeleteDepartment_thenReturnString() {
	  Optional<Department> dep = Optional.ofNullable(department); 
	  when(this.departmentRepo.findById(1)).thenReturn(dep);
	  
	  Assertions.assertEquals(this.departmentService.deleteById(1), "IT Department Deleted Successfully");
	  
  }
  
  @Test
  public void whenFindByID_thenReturnDepartment() {
	  Optional<Department> dep = Optional.ofNullable(department); 
	  when(this.departmentRepo.findById(1)).thenReturn(dep);
	  when(this.modelMapper.map(department, DepartmentOutDto.class))
	    .thenReturn(departmentOutDto);
	  Assertions.assertEquals(departmentOutDto, this.departmentService.findById(1));
	  
  }
  
  @Test
  public void  deleteById() {
	  when(this.departmentRepo.findById(1)).thenReturn(Optional.empty());
	  try {
          departmentService.deleteById(1);
          
      } catch (ResourceNotFound e) {
          assertEquals("Not Found", e.getMessage());
      }
  }
  
  @Test
  public void  findById() {
	  when(this.departmentRepo.findById(1)).thenReturn(Optional.empty());
	  try {
          departmentService.findById(1);
          
      } catch (ResourceNotFound e) {
          assertEquals("Department not found", e.getMessage());
      }
  }
  
  
  @Test
  public void testGetAllDepartmentByPagination() {
      
      Integer offset = 0;
      Pageable page = PageRequest.of(offset, 10, Sort.by("depName"));

      
      List<Department> departmentList = new ArrayList<>();
      departmentList.add(new Department());
      Page<Department> departmentPage = new PageImpl<>(departmentList);
      when(departmentRepo.findAll(page)).thenReturn(departmentPage);

      
      DepartmentOutDto departmentOutDto = new DepartmentOutDto();
      when(modelMapper.map(any(Department.class), eq(DepartmentOutDto.class))).thenReturn(departmentOutDto);

      
      List<DepartmentOutDto> result = departmentService.getAllDepartmentByPagination(offset);

      
      assertEquals(1, result.size()); 
      assertEquals(departmentOutDto, result.get(0)); 

      
      verify(departmentRepo, times(1)).findAll(page);
      verify(modelMapper, times(1)).map(any(Department.class), eq(DepartmentOutDto.class));
  }
}
