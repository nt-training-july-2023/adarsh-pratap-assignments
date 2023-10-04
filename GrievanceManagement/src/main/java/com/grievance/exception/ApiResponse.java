package com.grievance.exception;

/**
 * Api Response.
 */
public class ApiResponse {

  /**
   * String to store Entity.
   */
  private String entity;

  /**
   * String to store the message.
   */
  private String message;


  /**
   * Getter for entity.
   *
   * @return the entity
   */
  public String getEntity() {
    return entity;
  }

  /**
   * Setter for entity.
   *
   * @param e the entity to set
   */
  public void setEntity(final String e) {
    this.entity = e;
  }

  /**
   * getter for message.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Setter for message.
   *
   * @param newMessage the message to set
   */
  public void setMessage(final String newMessage) {
    this.message = newMessage;
  }
}
