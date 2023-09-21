package com.grievance.service;

import com.grievance.dto.DepartmentInDto;
import com.grievance.dto.DepartmentOutDto;
import com.grievance.entity.Department;
import com.grievance.exception.ResourceNotFound;
import com.grievance.repo.DepartmentRepo;
import com.grievance.serviceinterface.DepartmentServiceInterface;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Department service.
 */
@Service
public class DepartmentService implements DepartmentServiceInterface {

  /**
   * Autowired Department Repository.
   */
  @Autowired
  private DepartmentRepo departmentRepo;

  /**
   * ModelMapper Autowired.
   */
  @Autowired
  private ModelMapper modelMapper;

  /**
   * Adding the Department.
   *
   * @param departmentDto of type DepartmentInDto
   *
   * @return Department.
   */
  @Override
  public DepartmentOutDto addDepartment(final DepartmentInDto departmentDto) {
    Department department = this.modelMapper.map(
        departmentDto, Department.class);
    return this.modelMapper.map(
        this.departmentRepo.save(department),
        DepartmentOutDto.class
      );
  }

  /**
   * Find Department by Id.
   *
   * @param id of type Integer.
   *
   * @return Department.
   */
  @Override
  public DepartmentOutDto findById(final Integer id) {
    Department dep =
        this.departmentRepo.findById(id)
        .orElseThrow(
          () -> new ResourceNotFound(
          "Department.class", "Department not found")
        );
    return this.modelMapper.map(dep, DepartmentOutDto.class);
  }

  /**
   * Get All Department.
   *
   * @return List of all Department.
   */
  @Override
  public List<DepartmentOutDto> getAllDepartment() {
    List<Department> allDepartment = this.departmentRepo.findAll();

    List<DepartmentOutDto> departmentOutDtos
        = new ArrayList<DepartmentOutDto>();

    for (Department department : allDepartment) {
      departmentOutDtos.add(this.modelMapper.map(
          department, DepartmentOutDto.class));
    }

    return departmentOutDtos;
  }

  /**
   * Delete Department By ID.
   *
   * @param id Integer
   * @return String
   */
  @Override
  public String deleteById(Integer id) {
    Department dep = this.departmentRepo.findById(
        id).orElseThrow(() -> new ResourceNotFound(
        "Department", "Not Found"));
    this.departmentRepo.deleteById(id);
    return dep.getDepName() + " Department Deleted Successfully";
  }
}
