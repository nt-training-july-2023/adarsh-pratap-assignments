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

  /**
   * Find Employee By Email And Password.
   *
   * @param email String
   * @param password String
   * @return Optional Of Employee
   */
  Optional<Employee> findByEmailAndPassword(String email,String password);

  /**
   * Employee Exist By Email And Password And Role.
   *
   * @param email String
   * @param password String
   * @param roleAdmin Role
   * @return Boolean
   */
  boolean existsByEmailAndPasswordAndRole(String email,String password,Role roleAdmin);

  /**
   * Employee Exist By Email And Password.
   *
   * @param email String
   * @param password String
   * @return Boolean
   */
  boolean existsByEmailAndPassword(String email,String password);
}
