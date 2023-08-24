package com.example.demo.repo;

import com.example.demo.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Employee repository .
 */

@Repository
public interface  EmployeeRepo extends JpaRepository<Employees, Integer>{
	
	@Query
	Employees findByEmail(String userName);

}
