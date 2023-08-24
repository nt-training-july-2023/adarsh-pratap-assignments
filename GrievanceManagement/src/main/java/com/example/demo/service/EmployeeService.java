package com.example.demo.service;

import com.example.demo.dtos.EmployeesDto;
import com.example.demo.dtos.UserLogin;
import com.example.demo.entity.Employees;
import com.example.demo.repo.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Employee Service .
 */

@Service
public class EmployeeService {
  @Autowired
  private EmployeeRepo employeeRepo;

  @Autowired
  private ModelMapper modelMapper;

  /**
   * Save Employee .
   * 
   * @param empDto .
   * @return .
   */
  public EmployeesDto saveEmployee(EmployeesDto empDto) {
    Employees emp = this.modelMapper.map(empDto, Employees.class);

    return this.modelMapper.map(this.employeeRepo.save(emp), EmployeesDto.class);
  }

  /**
   * User login Method .
   *
   * @param login .
   *
   * @return String .
   */
  public String login(UserLogin login) {
    Employees emp = this.employeeRepo.findByEmail(login.getUserName());

    if (emp != null && emp.getPassword().equals(login.getPassword())) {
      return "Welcome " + emp.getRole();
    }
    return "Invalid User";
  }
}
