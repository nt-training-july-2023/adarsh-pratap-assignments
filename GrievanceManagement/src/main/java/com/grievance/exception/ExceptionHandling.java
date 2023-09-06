package com.grievance.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Handling Global Exception.
 */
@RestControllerAdvice
public class ExceptionHandling {

  /**
   * handling resource not found exception.
   *
   * @param e of type ResourceNotFound exception.
   * 
   * @return ResponseEntity.
   */
  @ExceptionHandler(ResourceNotFound.class)
  public ResponseEntity<ApiResponse> resourceNotFound(ResourceNotFound e) {
    ApiResponse apiResponse = new ApiResponse();
    apiResponse.setEntity(e.getEntity());
    apiResponse.setMessage(e.getMessage());
    return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> methodArgumentNotValid(MethodArgumentNotValidException ex ) {
   
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach(error -> {
        String fieldName = ((FieldError) error).getField();
        String errorMessage = error.getDefaultMessage();
        errors.put(fieldName, errorMessage);
    });
    return new ResponseEntity(errors, HttpStatus.BAD_REQUEST);
  }
  
  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<?> dataIntegrityViolationException(DataIntegrityViolationException ex ) {
	    
	    return new ResponseEntity("Check the not null and unique fields", HttpStatus.BAD_REQUEST);
	  }
}
