package com.grievance.service;

import com.grievance.dto.ChangePasswordDto;
import com.grievance.dto.EmployeeOutDto;
import com.grievance.dto.EmployeesDto;
import com.grievance.dto.UserLogin;
import com.grievance.entity.Employee;
import com.grievance.exception.ApiResponse;
import com.grievance.exception.ResourceNotFound;
import com.grievance.repo.EmployeeRepo;
import com.grievance.serviceinterface.EmployeeServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
  public EmployeeOutDto saveEmployee(final EmployeesDto empDto) {
    Employee emp = this.modelMapper.map(empDto, Employee.class);

    emp.setIsFirstLogin(true);

    return this.modelMapper.map(
      this.employeeRepo.save(emp), EmployeeOutDto.class);
  }

  /**
   * User login Method .
   *
   * @param login .
   *
   * @return String .
   */
  public EmployeeOutDto login(final UserLogin login) {
    Employee emp = this.employeeRepo.findByEmail(login.getUserName());

    if (emp != null && emp.getPassword().equals(login.getPassword())) {

      return this.modelMapper.map(emp, EmployeeOutDto.class);
    }
    return null;
  }

  /**
   * Get By Id.
   *
   * @param id Integer.
   *
   * @return EmployeeOutDto
   */
  public EmployeeOutDto getById(final Integer id) {
    Employee emp = this.employeeRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFound(
          "Employee", "Employee not Found for this Id"));
    return this.modelMapper.map(emp, EmployeeOutDto.class);
  }

  /**
   * Update Employee.
   *
   * @param id Integer
   * @param emp Employee
   * @return EmployeeOutDto
   */
  public EmployeeOutDto updateEmployee(
      final Integer id, final EmployeesDto emp) {
    Employee employee = this.employeeRepo.findById(id)
        .orElseThrow(
          () -> new ResourceNotFound("Employee", "Employee Not found"));
    employee.setDepartment(emp.getDepartment());;
    employee.setEmail(emp.getEmail());
    employee.setRole(emp.getRole());
    employee.setUserName(emp.getUserName());

    Employee result = this.employeeRepo.save(employee);
    return this.modelMapper.map(result, EmployeeOutDto.class);
  }

  /**
   * change Password.
   *
   * @param id Integer
   * @param changePasswordDto ChangePasswordDto
   * @return ApiResponse
   */
  public ApiResponse changePassword(
      final Integer id, final ChangePasswordDto changePasswordDto) {
    Employee employee  = this.employeeRepo.findById(id)
        .orElseThrow(
          () -> new ResourceNotFound("Employee", "Employee Not found"));

    ApiResponse apiResponse = new ApiResponse();

    if (changePasswordDto.getNewPassword().equals(
        changePasswordDto.getOldPassword())) {
      apiResponse.setEntity("Employee");
      apiResponse.setMessage(
          "old password and new password should not be same");
      return apiResponse;
    }

    if (changePasswordDto.getNewPassword().equals(
          changePasswordDto.getConfirmPassword())) {

      employee.setPassword(changePasswordDto.getNewPassword());
      this.employeeRepo.save(employee);
      apiResponse.setEntity("Employee");
      apiResponse.setMessage("Password changed Sucessfully!!");

    } else {
      apiResponse.setEntity("Employee");
      apiResponse.setMessage("New password and confirm password should be same");
    }
    return apiResponse;
  }
}
