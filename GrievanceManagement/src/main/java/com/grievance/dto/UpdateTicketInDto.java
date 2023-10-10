package com.grievance.dto;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.grievance.entity.TicketStatus;

/**
 * Update Ticket In Dto.
 */
public class UpdateTicketInDto {

  /**
   * Update ticket Status.
   */
  @NotNull(message = "Status can not be null")
  private TicketStatus status;

  /**
   * New Comment.
   */
  @NotEmpty(message = "Comment field is required")
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
   * getter for empName.
   *
   * @return the empName
   */
  public String getEmpName() {
    return empName;
  }

  /**
  * setter for empName.
  *
  * @param newEmpName the empName to set
  */
  public void setEmpName(final String newEmpName) {
    this.empName = newEmpName;
  }

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

  /**
   * Hash Code.
   */
  @Override
  public int hashCode() {
    return Objects.hash(comment, empName, status);
  }

  /**
   * Equals Method.
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    UpdateTicketInDto other = (UpdateTicketInDto) obj;
    return Objects.equals(comment, other.comment)
        && Objects.equals(empName, other.empName)
        && status == other.status;
  }
}

