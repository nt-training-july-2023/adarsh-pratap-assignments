package com.grievance.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


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
   * @param newTicketId the ticketId to set
   */
  public void setTicketId(final Integer newTicketId) {
    this.ticketId = newTicketId;
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
   * @param newTicketName the ticketName to set
   */
  public void setTicketName(final String newTicketName) {
    this.ticketName = newTicketName;
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
   * @param newDescription type String.
   */
  public void setDescription(final String newDescription) {
    this.description = newDescription;
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
   * @param newStatus the status to set
   */
  public void setStatus(final TicketStatus newStatus) {
    this.status = newStatus;
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
   * @param newCreationDate the creationDate to set
   */
  public void setCreationDate(final Date newCreationDate) {
    this.creationDate = newCreationDate;
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
   * @param newLastUpdateDate the lastUpdateDate to set
   */
  public void setLastUpdateDate(final Date newLastUpdateDate) {
    this.lastUpdateDate = newLastUpdateDate;
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
   * @param newTicketType the ticketType to set
   */
  public void setTicketType(final TicketType newTicketType) {
    this.ticketType = newTicketType;
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
   * @param newDepartment the department to set
   */
  public void setDepartment(final Department newDepartment) {
    this.department = newDepartment;
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
   * @param newEmployee the employee to set
   */
  public void setEmployee(final Employee newEmployee) {
    this.employee = newEmployee;
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
   * @param newComments the comments to set
   */
  public void setComments(final List<Comment> newComments) {
    this.comments = newComments;
  }

  /**
   * No args constructor.
   */
  public Ticket() {

  }
}
