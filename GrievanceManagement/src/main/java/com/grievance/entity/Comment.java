package com.grievance.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;

/**
 * Comments of ticket.
 */
@Entity
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer commentId;

  @Column(name = "comments", nullable = false)
  private String content;

  @Column(name = "creation_time")
  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  private Date creationTime;

  @Column(name = "emp_name", nullable = false)
  private String empName;

  @ManyToOne
  @JoinColumn(name = "ticket_id")
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

  public Comment(
    Integer commentId,
    String content,
    Date creationTime,
    String empName,
    Ticket ticket
  ) {
    super();
    this.commentId = commentId;
    this.content = content;
    this.creationTime = creationTime;
    this.empName = empName;
    this.ticket = ticket;
  }

  public Comment() {
    super();
  }
}
