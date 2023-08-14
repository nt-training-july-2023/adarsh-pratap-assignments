package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
public class EmployeeNotFound extends RuntimeException{
	
	private String message;
	
	private String entity;
	
	public EmployeeNotFound() {
		this.message = "Employee not found for given id";
		this.entity = "Employee";
	}
}
