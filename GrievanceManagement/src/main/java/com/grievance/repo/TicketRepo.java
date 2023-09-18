package com.grievance.repo;

import com.grievance.entity.Department;
import com.grievance.entity.Employee;
import com.grievance.entity.Role;
import com.grievance.entity.Ticket;
import com.grievance.entity.TicketStatus;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

  /**
   * Find by Status.
   *
   * @param status Status
   * @return List
   */
  @Query("SELECT t FROM Ticket t ORDER BY "
          + "CASE WHEN t.status = 'OPEN' THEN 1 "
          + "WHEN t.status = 'BEING_ADDRESSED' THEN 2 "
          + "WHEN t.status = 'RESOLVED' THEN 3 ELSE 4 END")
  List<Ticket> findByStatus();

  @Query("SELECT t FROM Ticket t " 
         + "WHERE t.employee = :employee " 
         + "AND t.status IN :status "
         + "ORDER BY CASE "
         + "  WHEN t.status = 'OPEN' THEN 1 "
         + "  WHEN t.status = 'BEING_ADDRESSED' THEN 2 "
         + "  WHEN t.status = 'RESOLVED' THEN 3 "
         + "  ELSE 4 END")
  List<Ticket> findByStatusInAndEmployee(@Param("status") TicketStatus[] status,@Param("employee") Employee employee);

  @Query("SELECT t FROM Ticket t " 
	         + "WHERE t.department = :dep " 
	         + "AND t.status IN :status "
	         + "ORDER BY CASE "
	         + "  WHEN t.status = 'OPEN' THEN 1 "
	         + "  WHEN t.status = 'BEING_ADDRESSED' THEN 2 "
	         + "  WHEN t.status = 'RESOLVED' THEN 3 "
	         + "  ELSE 4 END")
  List<Ticket> findByDepartmentAndStatus(@Param("dep") Department dep,@Param("status") TicketStatus[] status);


}
