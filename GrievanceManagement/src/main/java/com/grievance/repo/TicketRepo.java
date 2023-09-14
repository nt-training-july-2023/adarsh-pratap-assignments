package com.grievance.repo;

import com.grievance.entity.Department;
import com.grievance.entity.Employee;
import com.grievance.entity.Ticket;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Ticket Repository.
 */
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

  /**
   * Find by Employee.
   *
   * @param emp Employee
   *
   * @return List
   */
  List<Ticket> findByEmployee(Employee emp);

  /**
   * Find by Department.
   *
   * @return List
   */
  List<Ticket> findByDepartment(Department dep);
}
