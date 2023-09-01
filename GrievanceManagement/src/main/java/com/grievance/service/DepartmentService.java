package com.grievance.service;

import com.grievance.dto.DepartmentDto;
import com.grievance.entity.Department;
import com.grievance.exception.ResourceNotFound;
import com.grievance.repo.DepartmentRepo;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Department service.
 */
@Service
public class DepartmentService {
  /**
   * Autowired Department Repository.
   */
  @Autowired
  private DepartmentRepo departmentRepo;

  @Autowired
  private ModelMapper modelMapper;

  /**
   * Adding the Department.
   *
   * @param DepartmentDto of type Department.
   *
   * @return Department.
   */
  public DepartmentDto addDepartment(DepartmentDto departmentDto) {
    Department department = this.modelMapper.map(departmentDto, Department.class);
    return this.modelMapper.map(
        this.departmentRepo.save(department),
        DepartmentDto.class
      );
  }

  /**
   *Find Department by Id.
   *
   * @param id of type Integer.
   *
   * @return Department.
   */
  public DepartmentDto findById(Integer id) {
    Department dep =
      this.departmentRepo.findById(id)
        .orElseThrow(
          () -> new ResourceNotFound("Department.class", "Department not found")
        );
    return this.modelMapper.map(dep, DepartmentDto.class);
  }

  /**
   *Get All Department.
   *
   * @return List of all Department.
   */
  public List<DepartmentDto> getAllDepartment() {
    List<Department> allDepartment = this.departmentRepo.findAll();

    List<DepartmentDto> departmentDtos = new ArrayList<DepartmentDto>();

    for (Department department : allDepartment) {
      departmentDtos.add(this.modelMapper.map(department, DepartmentDto.class));
    }

    return departmentDtos;
  }
}
