package com.grievance.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.grievance.entity.TicketStatus;
import com.grievance.entity.TicketType;
import java.util.Date;
import java.util.List;


/**
 * TicketOutDto.
 */
public class TicketOutDto {

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
  @JsonBackReference(value = "dep")
  private DepartmentOutDto department;

  private String depName;

  private String empName;
  /**
   * employee.
   */
  @JsonBackReference(value = "emp")
  private EmployeeOutDto employee;

  /**
   * comments.
   */
  @JsonIgnore
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
   * getter for depName.
   *
 * @return the depName
 */
public String getDepName() {
return depName;}

/**
 * @param depName the depName to set
 */
public void setDepName(String depName) {
this.depName = depName;}

/**
 * @return the empName
 */
public String getEmpName() {
return empName;}

/**
 * @param empName the empName to set
 */
public void setEmpName(String empName) {
this.empName = empName;}

/**
  * setter for comments.
  *
  * @param newComment the comments to set
  */
  public void setComments(final List<CommentsDto> newComment) {
    this.comments = newComment;
  }

  /**
  * All Args constructor.
  *
  * @param newTicketId Integer
  * @param newTicketName String
  * @param newDescription String
  * @param newStatus TicketStatus
  * @param newCreationDate Date
  * @param newLastUpdateDate Date
  * @param newTicketType TicketTYpe
  * @param newDepartment Department
  * @param newEmployee EmployeeOutDto
  * @param newComment Comments
  */
  public TicketOutDto(
      final Integer newTicketId, final String newTicketName,
      final String newDescription, final TicketStatus newStatus,
      final Date newCreationDate, final Date newLastUpdateDate,
      final TicketType newTicketType, final DepartmentOutDto newDepartment,
      final EmployeeOutDto newEmployee, final List<CommentsDto> newComment) {
    super();
    this.ticketId = newTicketId;
    this.ticketName = newTicketName;
    this.description = newDescription;
    this.status = newStatus;
    this.creationDate = newCreationDate;
    this.lastUpdateDate = newLastUpdateDate;
    this.ticketType = newTicketType;
    this.department = newDepartment;
    this.employee = newEmployee;
    this.comments = newComment;
  }

  /**
  * NO args constructor.
  */
  public TicketOutDto() {
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
}

