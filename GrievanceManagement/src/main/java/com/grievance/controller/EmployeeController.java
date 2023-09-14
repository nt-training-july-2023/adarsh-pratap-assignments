/**
 * importing package .
 */

package com.grievance.controller;

import com.grievance.dto.ChangePasswordDto;
import com.grievance.dto.EmployeeOutDto;
import com.grievance.dto.EmployeesDto;
import com.grievance.dto.UserLogin;
import com.grievance.exception.ApiResponse;
import com.grievance.service.EmployeeService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * User Controller.
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
  /**
   * Employee Service .
   */
  @Autowired
  private EmployeeService employeeService;

  /**
   * Create Employee .
   *
   * @param empDto .
   *
   * @return saved employee .
   */
  @PostMapping("/add")
  public ResponseEntity<?> createEmployee(
      @Valid final @RequestBody EmployeesDto empDto) {
    return new ResponseEntity<>(
      this.employeeService.saveEmployee(empDto),
      HttpStatus.CREATED
    );
  }

  /**
   * Login api .
   *
   * @param userLogin
   *
   * @return String [Valid , Invalid]
   */
  @PostMapping("/login")
  public ResponseEntity<?> login(
      final @Valid @RequestBody UserLogin userLogin) {
    EmployeeOutDto result = this.employeeService.login(userLogin);
    if (result != null) {
      return new ResponseEntity<>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
    }
  }

  /**
   * Update employee.
   *
   * @param id Integer
   * @param employeeDto EmployeeDto
   * @return Response Entity
   */
  @PutMapping("/update/{id}")
  public ResponseEntity<?> updateEmployee(
      final @PathVariable(name = "id") Integer id,
      final @RequestBody EmployeesDto employeeDto) {
    return new ResponseEntity<>(
        this.employeeService.updateEmployee(id, employeeDto), HttpStatus.OK);
  }

  /**
   * Change Password.
   *
   * @param id Integer
   * @param changePasswordDto ChangePasswordDto
   * @return ApiResponse
   */
  @PutMapping("/changepass/{id}")
  public ResponseEntity<?> changePassword(
      final @PathVariable(name = "id") Integer id,
      final @RequestBody ChangePasswordDto changePasswordDto) {
    ApiResponse apiResponse =
        this.employeeService.changePassword(id, changePasswordDto);

    if (apiResponse.getMessage().equals("Password changed Sucessfully!!")) {
      return new ResponseEntity(apiResponse, HttpStatus.OK);
    } else {
      return new ResponseEntity(apiResponse, HttpStatus.BAD_REQUEST);
    }
  }
}
