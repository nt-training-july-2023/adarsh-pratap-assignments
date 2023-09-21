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

  /**
   * CommentId.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer commentId;

  /**
   * Content.
   */
  @Column(name = "comments", nullable = false)
  private String content;

  /**
   * creation time.
   */
  @Column(name = "creation_time")
  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  private Date creationTime;

  /**
   * employee Name.
   */
  @Column(name = "emp_name", nullable = false)
  private String empName;

  /**
   * Ticket.
   */
  @ManyToOne
  @JoinColumn(name = "ticket_id")
  private Ticket ticket;

  /**
   * getter for comentId.
   *
   * @return the commentId
   */
  public Integer getCommentId() {
    return commentId;
  }

  /**
   * setter  for commentId.
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
   * getter for creationDate.
   *
   * @return the creationTime
   */
  public Date getCreationTime() {
    return creationTime;
  }

  /**
   * Setter for creation date.
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
   * Setter for empName.
   *
   * @param newEmpName the empName to set
   */
  public void setEmpName(final String newEmpName) {
    this.empName = newEmpName;
  }

  /**
   * Getter for ticket.
   *
   * @return the ticket
   */
  public Ticket getTicket() {
    return ticket;
  }

  /**
   * Setter for ticket.
   *
   * @param newTicket the ticket to set
   */
  public void setTicket(final Ticket newTicket) {
    this.ticket = newTicket;
  }

  /**
   * All args constructor.
   *
   * @param newCommentId type Interger
   * @param newContent type String
   * @param newCreationTime type Date
   * @param newEmpName type String
   * @param newTicket type Ticket
   */
  public Comment(
      final Integer newCommentId,
      final String newContent,
      final Date newCreationTime,
      final String newEmpName,
      final Ticket newTicket
  ) {
    super();
    this.commentId = newCommentId;
    this.content = newContent;
    this.creationTime = newCreationTime;
    this.empName = newEmpName;
    this.ticket = newTicket;
  }

  /**
   * NO args constructor.
   */
  public Comment() {
    super();
  }
}
