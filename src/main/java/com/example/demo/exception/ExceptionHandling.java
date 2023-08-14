package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionHandling {

	@ExceptionHandler(EmployeeNotFound.class)
	public ResponseEntity<?> NotFound(EmployeeNotFound ex){
		
		ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse();
		apiExceptionResponse.setMessage(ex.getMessage());
		apiExceptionResponse.setEntity(ex.getEntity());
		
		return new ResponseEntity<>(apiExceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String ,String>> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex){
		
		Map<String , String > map = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach((err)->{
			String exceptionIn = ((FieldError) err).getField();
			String message = err.getDefaultMessage();
			map.put(exceptionIn, message);
			
		});
		
		return new ResponseEntity<>(map , HttpStatus.NOT_ACCEPTABLE);
	}
}
