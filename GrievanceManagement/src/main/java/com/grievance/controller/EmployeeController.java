/**
 * importing package .
 */

package com.grievance.controller;

import com.grievance.dto.ChangePasswordDto;
import com.grievance.dto.EmployeeOutDto;
import com.grievance.dto.EmployeesInDto;
import com.grievance.dto.UserLogin;
import com.grievance.exception.ApiResponse;
import com.grievance.serviceinterface.EmployeeServiceInterface;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * User Controller.
 *
 * @author adarsh
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
  /**
   * Employee Service .
   */
  @Autowired
  private EmployeeServiceInterface employeeService;

  /**
   * Logger.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(
      EmployeeController.class);

  /**
   * Create Employee .
   *
   * @param empDto .
   *
   * @return saved employee .
   */
  @PostMapping("/add")
  public ResponseEntity<?> createEmployee(
      @Valid final @RequestBody EmployeesInDto empDto) {
    LOGGER.info("Inside Create Employee Controller!!!");
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
    LOGGER.info("Inside Login Employee Controller!!!");
    EmployeeOutDto result = this.employeeService.login(userLogin);
    if (result != null) {
      return new ResponseEntity<>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<>("Invalid User!!", HttpStatus.BAD_REQUEST);
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
      final @RequestBody EmployeesInDto employeeDto) {
    LOGGER.info("Inside Update Employee Controller!!!");
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
    LOGGER.info("Inside Change Password Controller!!!");
    ApiResponse apiResponse =
        this.employeeService.changePassword(id, changePasswordDto);

    if (apiResponse.getMessage().equals("Password changed Sucessfully!!")) {
      return new ResponseEntity(apiResponse, HttpStatus.OK);
    } else {
      return
          new ResponseEntity(apiResponse, HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * Get All Employees.
   *
   * @param offset Integer
   * @param depName String
   * @return EmployeeOutDto List
   */
  @GetMapping("/getall")
  public ResponseEntity<?> getAllEmployee(
      final @RequestParam(required = true) Integer offset,
      final @RequestParam String depName) {
    LOGGER.info("Inside Get All Employee Controller!!!");
    return new ResponseEntity<>(
        this.employeeService.getAllEmployee(offset, depName), HttpStatus.OK);
  }


  /**
   * Delete Employee.
   *
   * @param id Integer
   *
   * @return String
   */
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteEmployee(
      final @PathVariable(name = "id") Integer id) {
    LOGGER.info("Inside Delete Employee Controller!!!");
    return new ResponseEntity<>(
          this.employeeService.deleteEmployee(id), HttpStatus.OK);
  }
}
