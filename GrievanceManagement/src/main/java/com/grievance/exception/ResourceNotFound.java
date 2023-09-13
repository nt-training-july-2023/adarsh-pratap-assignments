package com.grievance.exception;

/**
 * Resource not found exception .
 */
public class ResourceNotFound extends RuntimeException {

  /**
   * String value to store the entity name.
   */
  private String entity;

  /**
   * String value to store the respective message.
   */
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
   * @param ent the entity to set
   */
  public void setEntity(final String ent) {
    this.entity = ent;
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
   * @param mess the message to set
   */
  public void setMessage(final String mess) {
    this.message = mess;
  }

  /**
  * Constructor.
  *
  * @param ent of type String .
  *
  * @param mess of type String.
  */
  public ResourceNotFound(final String ent, final String mess) {
    super();
    this.entity = ent;
    this.message = mess;
  }
}
