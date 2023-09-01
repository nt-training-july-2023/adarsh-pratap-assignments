package com.grievance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grievance.entity.Employee;

/**
 * Employee repository .
 */

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
  /**
   * Find Employee by email .
   *
   * @param userName
   *
   * @return Employee.
   */
  @Query
  Employee findByEmail(String userName);
}
