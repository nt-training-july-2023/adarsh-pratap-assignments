package com.grievance.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
   * @param id the commentId to set
   */
  public void setCommentId(final Integer id) {
    this.commentId = id;
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
   * @param con the content to set
   */
  public void setContent(final String con) {
    this.content = con;
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
   * @param createTime the creationTime to set
   */
  public void setCreationTime(final Date createTime) {
    this.creationTime = createTime;
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
   * @param emp the empName to set
   */
  public void setEmpName(final String emp) {
    this.empName = emp;
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
   * @param tick the ticket to set
   */
  public void setTicket(final Ticket tick) {
    this.ticket = tick;
  }
}
