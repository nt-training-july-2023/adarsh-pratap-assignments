package com.grievance.controller;

import com.grievance.dto.DepartmentInDto;
import com.grievance.service.DepartmentService;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Department Controller.
 *
 * @author adarsh
 */
@Controller
@RequestMapping("/department")
@CrossOrigin("*")
public class DepartmentController {

  /**
   * DepartmentService Autowired.
   */
  @Autowired
  private DepartmentService departmentService;

  /**
   * Logger.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(
        EmployeeController.class);

  /**
   * Get all Department.
   *
   * @param offset Integer
   * @return ResonseEntity
   */
  @GetMapping("/getall")
  public ResponseEntity<?> getAllDepartment(
      final @RequestParam(required = false) Integer offset) {
    LOGGER.info("Inside Get All Department Controller!!!");
    if (offset == null) {
      return new ResponseEntity<>(this.departmentService.getAllDepartment(),
          HttpStatus.OK);
    } else {
      return new ResponseEntity<>(
          this.departmentService.getAllDepartmentByPagination(offset),
          HttpStatus.OK);
    }
  }

  /**
   *Save Department.
   *
   * @param departmentDto of type DepartmentDto.
   *
   * @return Department.
   */
  @PostMapping("/add")
  public ResponseEntity<?> saveDepartment(
      final @Valid @RequestBody DepartmentInDto departmentDto) {
    LOGGER.info("Inside Save Department Controller!!!");
    return new ResponseEntity<>(
      this.departmentService.addDepartment(departmentDto),
      HttpStatus.CREATED
    );
  }

  /**
   * Delete By Id.
   *
   * @param id Integer
   * @return String
   */
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteDepartment(
      final @PathVariable(name = "id") Integer id) {
    LOGGER.info("Inside Delete Department Controller!!!");
    return new ResponseEntity<>(this.departmentService.deleteById(id),
        HttpStatus.OK);
  }
}
