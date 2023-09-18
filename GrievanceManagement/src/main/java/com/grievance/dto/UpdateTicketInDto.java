package com.grievance.dto;

import com.grievance.entity.TicketStatus;

/**
 * Update Ticket In Dto.
 */
public class UpdateTicketInDto {

  /**
   * Update ticket Status.
   */
  private TicketStatus status;

  /**
   * New Comment.
   */
  private String comment;

  /**
   * Get Status.
   *
  * @return the status
  */
  public TicketStatus getStatus() {
    return status;
  }

  /**
  * Set Status.
  *
  * @param status the status to set
  */
  public void setStatus(TicketStatus status) {
    this.status = status;
  }

  /**
  * get comment.
  *
  * @return the comment
  */
  public String getComment() {
    return comment;
  }

  /**
  * Set Comments.
  *
  * @param com the comment to set
  */
  public void setComment(String com) {
    this.comment = com;
  }
}
