package com.grievance.service;

import com.grievance.controller.EmployeeController;
import com.grievance.dto.ChangePasswordDto;
import com.grievance.dto.EmployeeOutDto;
import com.grievance.dto.EmployeesInDto;
import com.grievance.dto.UserLogin;
import com.grievance.entity.Department;
import com.grievance.entity.Employee;
import com.grievance.exception.ApiResponse;
import com.grievance.exception.ResourceNotFound;
import com.grievance.repo.DepartmentRepo;
import com.grievance.repo.EmployeeRepo;
import com.grievance.serviceinterface.EmployeeServiceInterface;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
   * Department Repository.
   */
  @Autowired
  private DepartmentRepo departmentRepo;

  /**
   * Mapper.
   */
  @Autowired
  private ModelMapper modelMapper;

  /**
   * Logger.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(
      EmployeeController.class);

  /**
   * Save Employee .
   *
   * @param empDto .
   * @return .
   */
  @Override
  public EmployeeOutDto saveEmployee(final EmployeesInDto empDto) {
    LOGGER.info("Inside Save Employee {}", empDto.getUserName());
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
    LOGGER.info("Inside Login Employee {}", login.getUserName());
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
    LOGGER.info("Inside Get By Id Employee {}", id);
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
    LOGGER.info("Inside Update Employee {}", emp.getUserName());
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
    LOGGER.info("Inside Change Password ");
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
   * @param depName String
   *
   * @return List of EmployeeOutDto
   */
  @Override
  public List<EmployeeOutDto> getAllEmployee(final Integer offset,
      final String depName) {
    LOGGER.info("Inside Get All Employee {}", depName);
    final Integer pageSize = 10;
    Pageable page = PageRequest.of(offset, pageSize, Sort.by("userName"));
    Page<Employee> employee = null;
    if (depName.equals("all")) {
      employee = this.employeeRepo.findAll(page);
    } else {
      Department department = this.departmentRepo.findByDepName(depName);
      employee = this.employeeRepo.findByDepartment(department, page);
    }
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
  @Override
  public String deleteEmployee(final Integer id) {
    LOGGER.info("Inside Delete Employee");
    this.employeeRepo.findById(id).orElseThrow(() ->
          new ResourceNotFound("Employee", "Employee not found"));
    this.employeeRepo.deleteById(id);
    return "Employee deleted Sucessfully!!";
  }
}
