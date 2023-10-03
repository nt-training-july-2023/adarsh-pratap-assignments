package com.grievance.repo;

import com.grievance.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Department Repo.
 */

public interface DepartmentRepo extends JpaRepository<Department, Integer> {

  /**
   * Find By Department Name.
   *
   * @param depName String
   * @return Department
   */
  Department findByDepName(String depName);
}
