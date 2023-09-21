package com.example.demo.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.grievance.dto.DepartmentInDto;
import com.grievance.dto.EmployeesInDto;
import com.grievance.entity.Department;
import com.grievance.entity.Employee;
import com.grievance.entity.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class ModelMapperTesting {
  private ModelMapper mapper;

  private Employee employee;

  private EmployeesInDto employeeDto;

  @BeforeEach
  public void setup() {
    mapper = new ModelMapper();

    employee =
      new Employee(1, "Adarsh", "adarsh@gmail.com", "adarsh", Role.ROLE_ADMIN, null);
    
    Department dep = new Department(1 , "It" , null , null);
    employeeDto =
      new EmployeesInDto( "Adarsh", "adarsh@gmail.com", "adarsh", Role.ROLE_ADMIN, dep );
  }

  @Test
  public void givenEmployeeObject_whenMap_ReturnsEmployeeDto() {
    System.out.println(this.mapper.map(employee, EmployeesInDto.class));
    //		Assertions.assertEquals(this.modelMapper.map(employee , EmployeesDto.class),employeeDto);
    assertEquals(
      this.mapper.map(employee, EmployeesInDto.class).getUserName(),
      employeeDto.getUserName()
    );
    assertEquals(
      this.mapper.map(employee, EmployeesInDto.class).getPassword(),
      employeeDto.getPassword()
    );
  }
}
