/**
 * importing package .
 */

package com.example.demo.controller;

import com.example.demo.dtos.EmployeesDto;
import com.example.demo.dtos.UserLogin;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



/**
 * User Controller.
 */
@CrossOrigin("*")
@RestController
public class EmployeeController {
	
  @Autowired
  private EmployeeService employeeService;
  
  
  @PostMapping("/addemployee")
  public ResponseEntity<?> createEmployee(@RequestBody EmployeesDto empDto) {
    return new ResponseEntity<>(this.employeeService.saveEmployee(empDto), HttpStatus.CREATED);
  }
  
  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody UserLogin userLogin) {
    return new ResponseEntity(this.employeeService.login(userLogin), HttpStatus.OK);
  }

}
