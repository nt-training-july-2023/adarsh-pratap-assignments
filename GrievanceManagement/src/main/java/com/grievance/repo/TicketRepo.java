package com.grievance.repo;

import com.grievance.dto.DepartmentOutDto;
import com.grievance.entity.Department;
import com.grievance.entity.Employee;
import com.grievance.entity.Role;
import com.grievance.entity.Ticket;
import com.grievance.entity.TicketStatus;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Ticket Repository.
 */
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

  /**
   * Find Ticket By Employee.
   *
   * @param dep Department
   * @param of Page
   *
   * @return Page of tickets
   *
   */
  Page<Ticket> findByDepartment(Department dep, Pageable of);

  /**
   * Find ticket by Employee.
   *
   * @param employee Employee
   * @param of Page
   *
   * @return Page of Tickets
   */
  Page<Ticket> findByEmployee(Employee employee, Pageable of);

  /**
   * Find Ticket By Employee And Status.
   *
   * @param employee Employee
   * @param status Status
   * @param page Page
   * @return Page of tickets
   */
  Page<Ticket> findByEmployeeAndStatus(Employee employee, TicketStatus status, Pageable page);

  /**
   * Find tickets By Status.
   *
   * @param status Status
   * @param page Page
   * @return Page of tickets
   */
  Page<Ticket> findByStatus(TicketStatus status, Pageable page);

  /**
   * Find Ticket By Department And Status.
   *
   * @param department Department
   * @param status Status
   * @param page Page
   * @return Page of tickets
   */
  Page<Ticket> findByDepartmentAndStatus(Department department, TicketStatus status, Pageable page);

  /**
   * Find Ticket By Department And Employee.
   *
   * @param employee Employee
   * @param department Department
   * @param page Page
   * @return Page of tickets
   */
  Page<Ticket> findByEmployeeAndDepartment(Employee employee, Department department, Pageable page);

  /**
   * Find Ticket By Department And Employee And Status.
   *
   * @param department Department
   * @param employee Employee
   * @param status Status
   * @param page Page
   * @return Page of tickets
   */
  Page<Ticket> findByDepartmentAndEmployeeAndStatus(Department department,Employee employee,TicketStatus status,Pageable page);

  /**
   * Find Ticket By Status And Department Or Employee.
   *
   * @param department Department
   * @param employee Employee
   * @param status Status
   * @param page Page
   * @return Page of tickets
   */
  @Query("SELECT t FROM Ticket t WHERE (t.status = :status) AND (t.employee = :employee OR t.department = :department)")
  Page<Ticket> findByStatusAndDepartmentOrEmployee(Department department,Employee employee,TicketStatus status,Pageable page);

  /**
   * Find Ticket By Employee Or Department.
   *
   * @param employee Employee
   * @param department Department
   * @param page Page
   * @return Page of tickets
   */
  Page<Ticket> findByEmployeeOrDepartment(Employee employee,Department department,Pageable page);


}
