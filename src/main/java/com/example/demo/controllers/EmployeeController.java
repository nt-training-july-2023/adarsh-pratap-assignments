package com.example.demo.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;

import com.example.demo.service.EmployeeServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@GetMapping("/home")
	public ResponseEntity<?> home() {
		Employee emp = new Employee();
		return new ResponseEntity<String>("Welcome Employee" , HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById( @PathVariable("id") int id){
		return new ResponseEntity<>(this.employeeService.getEmployeeById(id) , HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllEmployees(){
		return new ResponseEntity(this.employeeService.getAllEmployees() , HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveEmployee(@Valid @RequestBody Employee emp){
		return new ResponseEntity(employeeService.addEmployee(emp) , HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id){
		return new ResponseEntity(employeeService.deleteEmployee(id ), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateEmployee(@Valid @RequestBody Employee emp , @PathVariable("id") int id){
		return new ResponseEntity(employeeService.updateEmployee(emp, id) , HttpStatus.OK);
	}
	
	@PostMapping("/addall")
	public ResponseEntity<?> saveMultipleEmployees(@RequestBody List<Employee> employees ){
		return new ResponseEntity(this.employeeService.addMultipleEmployees(employees) , HttpStatus.CREATED);
	}
}
