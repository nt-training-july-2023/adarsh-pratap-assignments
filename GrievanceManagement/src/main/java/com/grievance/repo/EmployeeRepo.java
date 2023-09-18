package com.grievance.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grievance.entity.Employee;
import com.grievance.entity.Role;

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

  Optional<Employee> findByEmailAndPassword(String email,String password);

  boolean existsByEmailAndPasswordAndRole(String email,String password,Role roleAdmin);

 boolean existsByEmailAndPassword(String email,String password);
}
