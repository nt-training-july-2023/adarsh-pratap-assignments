package com.grievance.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grievance.dto.EmployeesDto;
import com.grievance.dto.UserLogin;
import com.grievance.entity.Employee;
import com.grievance.repo.EmployeeRepo;
import com.grievance.serviceinterface.EmployeeServiceInterface;

/**
 * Employee Service .
 */

@Service
public class EmployeeService implements EmployeeServiceInterface {

  /**
   * Employee Repository .
   */
  @Autowired
  private EmployeeRepo employeeRepo;

  /**
   * Model Mapper Bean .
   */
  @Autowired
  private ModelMapper modelMapper;

  /**
   * Save Employee .
   *
   * @param empDto .
   * @return .
   */
  public EmployeesDto saveEmployee(final EmployeesDto empDto) {
    Employee emp = this.modelMapper.map(
        empDto, Employee.class);

    return this.modelMapper.map(
    this.employeeRepo.save(emp), EmployeesDto.class);
  }

  /**
   * User login Method .
   *
   * @param login .
   *
   * @return String .
   */
  public String login(final UserLogin login) {
    Employee emp = this.employeeRepo.findByEmail(login.getUserName());

    if (emp != null && emp.getPassword().equals(login.getPassword())) {
      return "Welcome " + emp.getRole();
    }
    return "Invalid User";
  }
}
