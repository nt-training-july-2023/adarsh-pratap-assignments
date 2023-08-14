package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Employee;

public interface EmployeeService {
	
	public Optional<Employee> getEmployeeById(int id);
	
	public Employee addEmployee(Employee emp);
	
	public Employee updateEmployee(Employee emp , int empId);
	
	public List<Employee> getAllEmployees();
	
	public String deleteEmployee(int id);
	
	public List<Employee> addMultipleEmployees(List<Employee> employees);
	
}