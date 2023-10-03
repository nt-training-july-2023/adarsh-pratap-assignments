package com.grievance.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grievance.entity.TicketStatus;
import com.grievance.entity.TicketType;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Ticket out dto with comments.
 */
public class TicketOutDtoWithComments {

  /**
  * Ticket ID.
  */
  private Integer ticketId;

  /**
  * TicketName.
  */
  private String ticketName;

  /**
  * description.
  */
  private String description;

  /**
  * status.
  */
  private TicketStatus status;

  /**
  * creation date.
  */
  @JsonFormat(pattern = "yyyy-MM-dd hh:mm aa", timezone = "Asia/Kolkata")
  private Date creationDate;

  /**
  * last updation date.
   */
  @JsonFormat(pattern = "yyyy-MM-dd hh:mm aa", timezone = "Asia/Kolkata")
  private Date lastUpdateDate;

  /**
  * ticket type.
  */
  private TicketType ticketType;

  /**
  * department.
  */
  private DepartmentOutDto department;

  /**
  * employee.
  */
  private EmployeeOutDto employee;

  /**
   * comments.
   */
  private List<CommentsDto> comments;

  /**
   * Ticket id getter.
   *
  * @return the ticketId.
  */
  public Integer getTicketId() {
    return ticketId;
  }

  /**
   * Setter for ticket id.
   *
  * @param newTicketId the ticketId to set
  */
  public void setTicketId(final Integer newTicketId) {
    this.ticketId = newTicketId;
  }

  /**
   * Getter for ticket name.
   *
  * @return the ticketName
  */
  public String getTicketName() {
    return ticketName;
  }

  /**
   * setter for ticket name.
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
   * Setter for description.
   *
  * @param newDescription the description to set
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
   * Setter for status.
   *
  * @param newStatus the status to set
  */
  public void setStatus(final TicketStatus newStatus) {
    this.status = newStatus;
  }

  /**
   * getter for creation Date.
   *
  * @return the creationDate
  */
  public Date getCreationDate() {
    return creationDate;
  }

  /**
  * setter for creation Date.
  *
  * @param newCreationDate the creationDate to set
  */
  public void setCreationDate(final Date newCreationDate) {
    this.creationDate = newCreationDate;
  }

  /**
  * getter for last update date.
  *
  * @return the lastUpdateDate
  */
  public Date getLastUpdateDate() {
    return lastUpdateDate;
  }

  /**
  * setter for last update date.
  *
  * @param newLastUpdateDate the lastUpdateDate to set
  */
  public void setLastUpdateDate(final Date newLastUpdateDate) {
    this.lastUpdateDate = newLastUpdateDate;
  }

  /**
  * getter for ticket type.
  *
  * @return the ticketType
  */
  public TicketType getTicketType() {
    return ticketType;
  }

  /**
  * set TicketType.
  *
  * @param newTicketType the ticketType to set
  */
  public void setTicketType(final TicketType newTicketType) {
    this.ticketType = newTicketType;
  }

  /**
  * get Department.
  *
  * @return the department
  */
  public DepartmentOutDto getDepartment() {
    return department;
  }

  /**
  * setter the department.
  *
  * @param newDepartment the department to set
  */
  public void setDepartment(final DepartmentOutDto newDepartment) {
    this.department = newDepartment;
  }

  /**
  * Get employee.
  *
  * @return the employee
  */
  public EmployeeOutDto getEmployee() {
    return employee;
  }

  /**
  * Setting the employee.
  *
  * @param newEmployee the employee to set
  */
  public void setEmployee(final EmployeeOutDto newEmployee) {
    this.employee = newEmployee;
  }

  /**
  * getter for comments.
  *
  * @return the comments
  */
  public List<CommentsDto> getComments() {
    return comments;
  }

  /**
  * setter for comments.
  *
  * @param newComments the comments to set
  */
  public void setComments(final List<CommentsDto> newComments) {
    this.comments = newComments;
  }

  /**
  * NO args constructor.
  */
  public TicketOutDtoWithComments() {
    super();
  }

  /**
   * to String method.
   */
  @Override
  public String toString() {
    return "TicketOutDto [ticketId="
      +
      ticketId
      +
      ", ticketName="
      +
      ticketName
      +
      ", description="
      +
      description
      +
      ", status="
      +
      status
      +
      ", creationDate="
      +
      creationDate
      +
      ", lastUpdateDate="
      +
      lastUpdateDate
      +
      ", ticketType="
      +
      ticketType
      +
      ", department="
      +
      department
      +
      ", employee="
      +
      employee
      +
      ", comments="
      +
      comments
      +
      "]";
  }

  /**
   * Hash Code For TicketOutDtoWithComments.
   */
  @Override
  public int hashCode() {
    return Objects.hash(comments, department, description,
    employee, status, ticketId, ticketName, ticketType);
  }

  /**
   * Equals method for TicketOutDtoWithComments.
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
    TicketOutDtoWithComments other = (TicketOutDtoWithComments) obj;
    return Objects.equals(comments, other.comments)
      && Objects.equals(department, other.department)
      && Objects.equals(description, other.description)
      && Objects.equals(employee, other.employee)
      && status == other.status
      && Objects.equals(ticketId, other.ticketId)
      && Objects.equals(ticketName, other.ticketName)
      && ticketType == other.ticketType;
  }
}


