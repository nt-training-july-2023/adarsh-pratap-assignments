package com.grievance.exception;

/**
 * Resource not found exception .
 */
public class ResourceNotFound extends RuntimeException {
  private String entity;

  private String message;

  /**
   * getter of Entity.
   *
   * @return the entity
   */
  public String getEntity() {
    return entity;
  }

  /**
   * Setter of entity.
   *
   * @param entity the entity to set
   */
  public void setEntity(String entity) {
    this.entity = entity;
  }

  /**
   * Get message.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * set message.
   *
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
  * Constructor.
  *
  * @param entity of type String .
  *
  * @param message of type String.
  */
  public ResourceNotFound(String entity, String message) {
    super();
    this.entity = entity;
    this.message = message;
  }
}
