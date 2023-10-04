package com.grievance.service;

import com.grievance.controller.EmployeeController;
import com.grievance.dto.DepartmentInDto;
import com.grievance.dto.DepartmentOutDto;
import com.grievance.entity.Department;
import com.grievance.exception.ResourceNotFound;
import com.grievance.repo.DepartmentRepo;
import com.grievance.serviceinterface.DepartmentServiceInterface;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
   * Logger.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(
      EmployeeController.class);

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
    LOGGER.info("Inside Add Department Method Department Service");
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
    LOGGER.info("Inside Find By Id Method Department Service");
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
    LOGGER.info("Inside Get All Department Method Department Service");
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
   * Get all Department By Pagination.
   */
  @Override
  public List<DepartmentOutDto> getAllDepartmentByPagination(
      final Integer offset) {
    LOGGER.info(
        "Inside Get all Department By Pagination Method Department Service");
    final Integer pageSize = 10;
    Pageable page = PageRequest.of(offset, pageSize);
    Page<Department> allDepartment = this.departmentRepo.findAll(page);
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
  public String deleteById(final Integer id) {
    LOGGER.info("Inside Delete By Id Department Method Department Service");
    Department dep = this.departmentRepo.findById(
        id).orElseThrow(() -> new ResourceNotFound(
        "Department", "Not Found"));
    this.departmentRepo.deleteById(id);
    return dep.getDepName() + " Department Deleted Successfully";
  }
}
