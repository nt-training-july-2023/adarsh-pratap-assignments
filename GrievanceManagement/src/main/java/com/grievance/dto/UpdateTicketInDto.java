package com.grievance.dto;

import javax.validation.constraints.NotEmpty;

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
   * Employee Name.
   */
  @NotEmpty(message = "Employee Name can not be Empty")
  private String empName;

  /**
   * Get Status.
   *
  * @return the status
  */
  public TicketStatus getStatus() {
    return status;
  }

  /**
	 * @return the empName
	 */
	public String getEmpName() {
	return empName;}
	
	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
	this.empName = empName;}

/**
  * Set Status.
  *
  * @param newStatus the status to set
  */
  public void setStatus(final TicketStatus newStatus) {
    this.status = newStatus;
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
  * @param newComment the comment to set
  */
  public void setComment(final String newComment) {
    this.comment = newComment;
  }
}
