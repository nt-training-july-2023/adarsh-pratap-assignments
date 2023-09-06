package com.grievance.serviceinterface;

import com.grievance.dto.EmployeeOutDto;
import com.grievance.dto.EmployeesDto;
import com.grievance.dto.UserLogin;

/**
 * Interface for employee service .
 */
public interface EmployeeServiceInterface {
  /**
   *save employee .
   *
   * @param empDto
   *
   * @return EmployeeDto
   */
	EmployeeOutDto saveEmployee(EmployeesDto empDto);

  /**
   * login method .
   *
   * @param login
   *
   * @return String
   */
  String login(UserLogin login);
}
