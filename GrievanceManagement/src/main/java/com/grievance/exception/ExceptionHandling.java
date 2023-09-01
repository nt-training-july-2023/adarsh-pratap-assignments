package com.grievance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
