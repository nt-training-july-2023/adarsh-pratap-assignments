package com.grievance.repo;

import com.grievance.entity.Employee;
import com.grievance.entity.Ticket;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Ticket Repository.
 */
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

List<Ticket> findByEmployee(Employee emp);
}
