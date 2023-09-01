package com.grievance.exception;

/**
 * Api Response.
 */
public class ApiResponse {
  private String entity;

  private String message;

  /**
   * @return the entity
   */
  public String getEntity() {
    return entity;
  }

  /**
   * @param entity the entity to set
   */
  public void setEntity(String entity) {
    this.entity = entity;
  }

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }
}
