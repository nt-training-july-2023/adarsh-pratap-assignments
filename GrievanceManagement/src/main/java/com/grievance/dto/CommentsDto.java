package com.grievance.dto;

import com.grievance.entity.Ticket;
import java.util.Date;

public class CommentsDto {
  private Integer commentId;

  private String content;

  private Date creationTime;

  private String empName;

  private Ticket ticket;

  /**
   * @return the commentId
   */
  public Integer getCommentId() {
    return commentId;
  }

  /**
   * @param commentId the commentId to set
   */
  public void setCommentId(Integer commentId) {
    this.commentId = commentId;
  }

  /**
   * @return the content
   */
  public String getContent() {
    return content;
  }

  /**
   * @param content the content to set
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * @return the creationTime
   */
  public Date getCreationTime() {
    return creationTime;
  }

  /**
   * @param creationTime the creationTime to set
   */
  public void setCreationTime(Date creationTime) {
    this.creationTime = creationTime;
  }

  /**
   * @return the empName
   */
  public String getEmpName() {
    return empName;
  }

  /**
   * @param empName the empName to set
   */
  public void setEmpName(String empName) {
    this.empName = empName;
  }

  /**
   * @return the ticket
   */
  public Ticket getTicket() {
    return ticket;
  }

  /**
   * @param ticket the ticket to set
   */
  public void setTicket(Ticket ticket) {
    this.ticket = ticket;
  }
}
