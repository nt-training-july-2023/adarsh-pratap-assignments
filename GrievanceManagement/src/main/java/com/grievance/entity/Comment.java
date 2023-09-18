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
   * @param name the empName to set
   */
  public void setEmpName(final String name) {
    this.empName = name;
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
   * @param tick the ticket to set
   */
  public void setTicket(final Ticket tick) {
    this.ticket = tick;
  }

  /**
   * All args constructor.
   *
   * @param id type Interger
   * @param con type String
   * @param createDate type Date
   * @param name type String
   * @param tick type Ticket
   */
  public Comment(
      final Integer id,
      final String con,
      final Date createDate,
      final String name,
      final Ticket tick
  ) {
    super();
    this.commentId = id;
    this.content = con;
    this.creationTime = createDate;
    this.empName = name;
    this.ticket = tick;
  }

  /**
   * NO args constructor.
   */
  public Comment() {
    super();
  }
}
