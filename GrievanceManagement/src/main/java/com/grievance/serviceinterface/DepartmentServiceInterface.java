package com.grievance.serviceinterface;

import com.grievance.dto.DepartmentInDto;
import com.grievance.dto.DepartmentOutDto;
import java.util.List;

/**
 * Department Service Interface.
 */
public interface DepartmentServiceInterface {
  /**
   * Adding the Department.
   *
   * @param departmentDto of type DepartmentInDto
   *
   * @return Department.
   */
  DepartmentOutDto addDepartment(DepartmentInDto departmentDto);

  /**
   * Find Department by Id.
   *
   * @param id of type Integer.
   *
   * @return Department.
   */
  DepartmentOutDto findById(Integer id);

  /**
   * Get All Department.
   *
   * @return List of all Department.
   */
  List<DepartmentOutDto> getAllDepartment();

  /**
   * Delete Department By ID.
   *
   * @param id Integer
   * @return String
   */
  String deleteById(Integer id);

  /**
   * Get all Department.
   *
   * @param offset Integer
   * @return List of Department out dto
   */
  List<DepartmentOutDto> getAllDepartmentByPagination(Integer offset);
}
