package com.grievance.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
  private Date creationDate;

  /**
   * last updation date.
   */
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

  /**
   * employee.
   */
  @JsonBackReference(value = "emp")
  private EmployeeOutDto employee;

  /**
   * comments.
   */
  @JsonIgnore
//  @JsonManagedReference(value = "comm")
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
  * @param id the ticketId to set
  */
  public void setTicketId(final Integer id) {
    this.ticketId = id;
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
  * @param name the ticketName to set
  */
  public void setTicketName(final String name) {
    this.ticketName = name;
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
  * @param des the description to set
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
   * Setter for status.
   *
  * @param stat the status to set
  */
  public void setStatus(final TicketStatus stat) {
    this.status = stat;
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
  * @param createDate the creationDate to set
  */
  public void setCreationDate(final Date createDate) {
    this.creationDate = createDate;
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
  * @param lastUpdate the lastUpdateDate to set
  */
  public void setLastUpdateDate(final Date lastUpdate) {
    this.lastUpdateDate = lastUpdate;
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
  * @param type the ticketType to set
  */
  public void setTicketType(final TicketType type) {
    this.ticketType = type;
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
  * @param dep the department to set
  */
  public void setDepartment(final DepartmentOutDto dep) {
    this.department = dep;
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
  * @param emp the employee to set
  */
  public void setEmployee(final EmployeeOutDto emp) {
    this.employee = emp;
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
  * @param comm the comments to set
  */
  public void setComments(final List<CommentsDto> comm) {
    this.comments = comm;
  }

  /**
  * All Args constructor.
  *
  * @param id Integer
  * @param name String
  * @param des String
  * @param stat TicketStatus
  * @param createDate Date
  * @param lastUpdate Date
  * @param type TicketTYpe
  * @param dep Department
  * @param emp EmployeeOutDto
  * @param comm Comments
  */
  public TicketOutDto(
      final Integer id, final String name,
      final String des, final TicketStatus stat,
      final Date createDate, final Date lastUpdate,
      final TicketType type, final DepartmentOutDto dep,
      final EmployeeOutDto emp, final List<CommentsDto> comm) {
    super();
    this.ticketId = id;
    this.ticketName = name;
    this.description = des;
    this.status = stat;
    this.creationDate = createDate;
    this.lastUpdateDate = lastUpdate;
    this.ticketType = type;
    this.department = dep;
    this.employee = emp;
    this.comments = comm;
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

