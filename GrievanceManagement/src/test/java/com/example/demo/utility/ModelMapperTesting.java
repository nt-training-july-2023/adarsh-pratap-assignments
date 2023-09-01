package com.example.demo.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.grievance.dto.EmployeesDto;
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

  private EmployeesDto employeeDto;

  @BeforeEach
  public void setup() {
    mapper = new ModelMapper();

    employee =
      new Employee(1, "Adarsh", "adarsh@gmail.com", "adarsh", Role.ROLE_ADMIN, null);
    employeeDto =
      new EmployeesDto(1, "Adarsh", "adarsh@gmail.com", "adarsh", Role.ROLE_ADMIN, null);
  }

  @Test
  public void givenEmployeeObject_whenMap_ReturnsEmployeeDto() {
    System.out.println(this.mapper.map(employee, EmployeesDto.class));
    //		Assertions.assertEquals(this.modelMapper.map(employee , EmployeesDto.class),employeeDto);
    assertEquals(
      this.mapper.map(employee, EmployeesDto.class).getUserName(),
      employeeDto.getUserName()
    );
    assertEquals(
      this.mapper.map(employee, EmployeesDto.class).getPassword(),
      employeeDto.getPassword()
    );
  }
}
