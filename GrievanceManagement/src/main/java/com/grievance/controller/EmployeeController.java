/**
 * importing package .
 */

package com.grievance.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grievance.dto.EmployeesDto;
import com.grievance.dto.UserLogin;
import com.grievance.service.EmployeeService;

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
      final @RequestBody EmployeesDto empDto) {
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
    String result = this.employeeService.login(userLogin);
    if (result != "Invalid User") {
      return new ResponseEntity<>(result, HttpStatus.OK);
    }
    else {
    return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
    }
   }
  

}
