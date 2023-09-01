package com.grievance.controller;

import com.grievance.dto.DepartmentDto;
import com.grievance.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Department Controller.
 */

@Controller
@RequestMapping("/department/")
@CrossOrigin("*")
public class DepartmentController {
  @Autowired
  private DepartmentService departmentService;

  /**
   * Get all Department.
   *
   * @return ResonseEntity
   */
  @GetMapping("getall")
  public ResponseEntity<?> getAllDepartment() {
    return new ResponseEntity<>(this.departmentService.getAllDepartment(), HttpStatus.OK);
  }

  /**
   *Save Department.
   *
   * @param departmentDto of type DepartmentDto.
   *
   * @return Department.
   */
  @PostMapping("save")
  public ResponseEntity<?> saveDepartment(@RequestBody DepartmentDto departmentDto) {
    return new ResponseEntity<>(
      this.departmentService.addDepartment(departmentDto),
      HttpStatus.OK
    );
  }
}
