package com.grievance.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.grievance.entity.Ticket;
import java.util.Date;

/**
 * Comments In DTO.
 */
public class CommentsDto {
  /**
   * Comments Id.
   */
  private Integer commentId;

  /**
   * content.
   */
  private String content;

  /**
   * Creation time.
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kolkata")
  private Date creationTime;

  /**
   * employee name.
   */
  private String empName;

  /**
   * ticket.
   */
  @JsonBackReference(value = "comm")
  private Ticket ticket;

  /**
   * getter for CommentID.
   *
   * @return the commentId
   */
  public Integer getCommentId() {
    return commentId;
  }

  /**
   * setter for commentId.
   *
   * @param newCommentId the commentId to set
   */
  public void setCommentId(final Integer newCommentId) {
    this.commentId = newCommentId;
  }

  /**
   * getter for content.
   *
   * @return the content
   */
  public String getContent() {
    return content;
  }

  /**
   * setter for content.
   *
   * @param newContent the content to set
   */
  public void setContent(final String newContent) {
    this.content = newContent;
  }

  /**
   * getter for creation time.
   *
   * @return the creationTime
   */
  public Date getCreationTime() {
    return creationTime;
  }

  /**
   * Setter for creationTime.
   *
   * @param newCreationTime the creationTime to set
   */
  public void setCreationTime(final Date newCreationTime) {
    this.creationTime = newCreationTime;
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
   * getter for ticket.
   *
   * @return the ticket
   */
  public Ticket getTicket() {
    return ticket;
  }

  /**
   * setter for ticket.
   *
   * @param newTicket the ticket to set
   */
  public void setTicket(final Ticket newTicket) {
    this.ticket = newTicket;
  }
}
