package com.grievance.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Ticket class.
 */
@Entity
public class Ticket {

  /**
   * TicketId.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer ticketId;

  /**
   * TicketName.
   */
  @Column(name = "ticket_name", nullable = false)
  private String ticketName;

  /**
   * Description.
   */
  @Column(name = "description")
  private String description;

  /**
   * TicketStatus.
   */
  @Enumerated(EnumType.STRING)
  private TicketStatus status;

  /**
   * CreationDate.
   */
  private Date creationDate;

  /**
   * LastUpdateDate.
   */
  @Column(name = "last_update")
  private Date lastUpdateDate;

  /**
   * TicketType.
   */
  @Column(name = "ticket_type")
  @Enumerated(EnumType.STRING)
  private TicketType ticketType;

  /**
   * Department.
   */
  @ManyToOne
  @JoinColumn(name = "department_id")
  @JsonBackReference(value = "dep")
  private Department department;

  /**
   * Employee.
   */
  @ManyToOne
  @JoinColumn(name = "employee_id")
  @JsonBackReference(value = "emp")
  private Employee employee;

  /**
   * List of Comments.
   */
  @OneToMany(
      cascade = CascadeType.ALL, mappedBy = "ticket", fetch = FetchType.LAZY)
  private List<Comment> comments;

  /**
   * getter for ticketId.
   *
   * @return the ticketId
   */
  public Integer getTicketId() {
    return ticketId;
  }

  /**
   * setter for ticketId.
   *
   * @param tickId the ticketId to set
   */
  public void setTicketId(final Integer tickId) {
    this.ticketId = tickId;
  }

  /**
   * getter for ticketName.
   *
   * @return the ticketName
   */
  public String getTicketName() {
    return ticketName;
  }

  /**
   * setter for ticketName.
   *
   * @param tickName the ticketName to set
   */
  public void setTicketName(final String tickName) {
    this.ticketName = tickName;
  }

  /**
   * getter for description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * setter for description.
   *
   * @param des type String.
   */
  public void setDescription(final String des) {
    this.description = des;
  }

  /**
   * getter for status.
   *
   * @return the status
   */
  public TicketStatus getStatus() {
    return status;
  }

  /**
   * setter for status .
   *
   * @param stat the status to set
   */
  public void setStatus(final TicketStatus stat) {
    this.status = stat;
  }

  /**
   * getter CreationDate.
   *
   * @return the creationDate
   */
  public Date getCreationDate() {
    return creationDate;
  }

  /**
   * setter for creationDate.
   *
   *
   * @param createDate the creationDate to set
   */
  public void setCreationDate(final Date createDate) {
    this.creationDate = createDate;
  }

  /**
   * getter lastUpdateDate.
   *
   * @return the lastUpdateDate
   */
  public Date getLastUpdateDate() {
    return lastUpdateDate;
  }

  /**
   * setter for lastUpdatedDate.
   *
   * @param lastUpDate the lastUpdateDate to set
   */
  public void setLastUpdateDate(final Date lastUpDate) {
    this.lastUpdateDate = lastUpDate;
  }

  /**
   * getter for ticketType.
   *
   * @return the ticketType
   */
  public TicketType getTicketType() {
    return ticketType;
  }

  /**
   * set ticketType.
   *
   * @param ticketT the ticketType to set
   */
  public void setTicketType(final TicketType ticketT) {
    this.ticketType = ticketT;
  }

  /**
   * get department.
   *
   * @return the department
   */
  public Department getDepartment() {
    return department;
  }

  /**
   * set department.
   *
   * @param dep the department to set
   */
  public void setDepartment(final Department dep) {
    this.department = dep;
  }

  /**
   * get employee.
   *
   * @return the employee
   */
  public Employee getEmployee() {
    return employee;
  }

  /**
   * set employee.
   *
   * @param emp the employee to set
   */
  public void setEmployee(final Employee emp) {
    this.employee = emp;
  }

  /**
   * get comments.
   *
   * @return the comments
   */
  public List<Comment> getComments() {
    return comments;
  }

  /**
   * set comments.
   *
   * @param com the comments to set
   */
  public void setComments(final List<Comment> com) {
    this.comments = com;
  }

  /**
   * All args constructor.
   *
   * @param tickId Integer.
   * @param tickName String.
   * @param des String.
   * @param stat TicketStatus.
   * @param createDate Date.
   * @param lastUpDate Date.
   * @param tickType TicketType.
   * @param dep Department.
   * @param emp Employee.
   * @param com Comments.
   */
  public Ticket(final Integer tickId, final String tickName,
      final String des,
      final TicketStatus stat, final Date createDate,
      final Date lastUpDate,
      final TicketType tickType, final Department dep,
      final Employee emp,
      final List<Comment> com) {
    super();
    this.ticketId = tickId;
    this.ticketName = tickName;
    this.description = des;
    this.status = stat;
    this.creationDate = createDate;
    this.lastUpdateDate = lastUpDate;
    this.ticketType = tickType;
    this.department = dep;
    this.employee = emp;
    this.comments = com;
  }

  /**
   * No args constructor.
   */
  public Ticket() {

  }
}
