package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.exception.EmployeeNotFound;

import com.example.demo.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Optional<Employee> getEmployeeById(int id) {
		Employee employee = this.employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFound());
		return Optional.of(employee);
	}

	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return this.employeeRepository.save(emp);
	}

	@Override
	public Employee updateEmployee(Employee emp, int empId) {
		
		Employee employee = getEmployeeById(empId).orElseThrow(()->new EmployeeNotFound());
		
		employee.setCity(emp.getCity());
		employee.setContact(emp.getContact());
		employee.setEmpName(emp.getEmpName());
		
		
		return this.employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return this.employeeRepository.findAll();
	}
	
	

	@Override
	public String deleteEmployee(int id) {
		Optional<Employee> emp = this.getEmployeeById(id);
		if(emp != null)
			this.employeeRepository.deleteById(id);
		return "Employee Deleted!!";
	}

	@Override
	public List<Employee> addMultipleEmployees(List<Employee> employees) {
	    return this.employeeRepository.saveAll(employees);
	}

}
