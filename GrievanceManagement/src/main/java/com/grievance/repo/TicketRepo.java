package com.grievance.repo;

import com.grievance.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Ticket Repository.
 */
public interface TicketRepo extends JpaRepository<Ticket, Integer> {}
