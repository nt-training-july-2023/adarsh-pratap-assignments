package com.grievance.serviceinterface;

import com.grievance.dto.ChangePasswordDto;
import com.grievance.dto.EmployeeOutDto;
import com.grievance.dto.EmployeesInDto;
import com.grievance.dto.UserLogin;
import com.grievance.exception.ApiResponse;

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
  EmployeeOutDto saveEmployee(EmployeesInDto empDto);

  /**
   * login method .
   *
   * @param login
   *
   * @return String
   */
  EmployeeOutDto login(UserLogin login);

   /**
   * Get By Id.
   *
   * @param id Integer.
   *
   * @return EmployeeOutDto
   */EmployeeOutDto getById(Integer id);

   /**
   * Update Employee.
   *
   * @param id Integer
   * @param emp Employee
   * @return EmployeeOutDto
   */EmployeeOutDto updateEmployee(Integer id, EmployeesInDto emp);

   /**
   * change Password.
   *
   * @param id Integer
   * @param changePasswordDto ChangePasswordDto
   * @return ApiResponse
   */ApiResponse changePassword(Integer id, ChangePasswordDto changePasswordDto);
}
