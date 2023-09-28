package com.grievance.service;

import com.grievance.dto.ChangePasswordDto;
import com.grievance.dto.EmployeeOutDto;
import com.grievance.dto.EmployeesInDto;
import com.grievance.dto.UserLogin;
import com.grievance.entity.Employee;
import com.grievance.exception.ApiResponse;
import com.grievance.exception.ResourceNotFound;
import com.grievance.repo.EmployeeRepo;
import com.grievance.serviceinterface.EmployeeServiceInterface;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
   * Mapper.
   */
  @Autowired
  private ModelMapper modelMapper;

  /**
   * Save Employee .
   *
   * @param empDto .
   * @return .
   */
  @Override
  public EmployeeOutDto saveEmployee(final EmployeesInDto empDto) {
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
  @Override
  public EmployeeOutDto login(final UserLogin login) {
    Employee emp = this.employeeRepo.findByEmail(login.getUserName());

    if (emp != null && emp.getPassword().equals(login.getPassword())) {
      EmployeeOutDto empOut = this.modelMapper.map(emp, EmployeeOutDto.class);
      empOut.setDepName(emp.getDepartment().getDepName());
      return empOut;
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
  @Override
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
  @Override
  public EmployeeOutDto updateEmployee(
      final Integer id, final EmployeesInDto emp) {
    Employee employee = this.employeeRepo.findById(id)
        .orElseThrow(
          () -> new ResourceNotFound("Employee", "Employee Not found"));
    employee.setDepartment(emp.getDepartment());
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
  @Override
  public ApiResponse changePassword(
      final Integer id, final ChangePasswordDto changePasswordDto) {
    Employee employee  = this.employeeRepo.findById(id)
        .orElseThrow(
          () -> new ResourceNotFound("Employee", "Employee Not found"));

    ApiResponse apiResponse = new ApiResponse();

    if (!employee.getPassword().equals(changePasswordDto.getOldPassword())) {
      apiResponse.setEntity("Employee");
      apiResponse.setMessage(
            "old password is incorrect!!");
      return apiResponse;
    }
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
      employee.setIsFirstLogin(false);
      this.employeeRepo.save(employee);
      apiResponse.setEntity("Employee");
      apiResponse.setMessage("Password changed Sucessfully!!");

    } else {
      apiResponse.setEntity("Employee");
      apiResponse.setMessage(
          "New password and confirm password should be same");
    }
    return apiResponse;
  }

  /**
   * Get All Employee.
   *
   * @param offset Integer
   * @return List of EmployeeOutDto
   */
  public List<EmployeeOutDto> getAllEmployee(final Integer offset) {
    final Integer pageSize = 10;
    Pageable page = PageRequest.of(offset, pageSize);
    Page<Employee> employee = this.employeeRepo.findAll(page);

    List<EmployeeOutDto> result = new ArrayList<EmployeeOutDto>();
    for (Employee emp : employee) {
      EmployeeOutDto employeeDto =  this.modelMapper.map(
          emp, EmployeeOutDto.class);
      employeeDto.setDepName(emp.getDepartment().getDepName());
      result.add(employeeDto);
    }
    return result;
  }

  /**
   * Delete Employee.
   *
   * @param id Integer
   * @return String
   */
  public String deleteEmployee(final Integer id) {
    Employee emp = this.employeeRepo.findById(id).orElseThrow(() ->
          new ResourceNotFound("Employee", "Employee not found"));
    this.employeeRepo.deleteById(id);
    return "Employee deleted Sucessfully!!";
  }
}
