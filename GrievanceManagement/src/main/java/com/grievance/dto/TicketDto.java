package com.grievance.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.grievance.entity.Department;
import com.grievance.entity.Employee;
import com.grievance.entity.TicketStatus;
import com.grievance.entity.TicketType;

/**
 * Ticket In DTO.
 */
public class TicketDto {
  @NotEmpty(message = "Ticket name can not be empty")
  private String ticketName;

  @NotEmpty(message = "description is required filed")
  private String description;

  private TicketStatus status;

//  @NotEmpty(message = "ticket type required")
  private TicketType ticketType;


  @NotNull
  private Department department;


  @NotNull
  private Employee employee;

  /**
   * @return the ticketName
   */
  public String getTicketName() {
    return ticketName;
  }

  /**
   * @param ticketName the ticketName to set
   */
  public void setTicketName(String ticketName) {
    this.ticketName = ticketName;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return the status
   */
  public TicketStatus getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(TicketStatus status) {
    this.status = status;
  }

  /**
   * @return the ticketType
   */
  public TicketType getTicketType() {
    return ticketType;
  }

  /**
   * set TicketType.
   *
   * @param ticketType the ticketType to set
   */
  public void setTicketType(TicketType ticketType) {
    this.ticketType = ticketType;
  }

  /**
   * get Department.
   *
   * @return the department
   */
  public Department getDepartment() {
    return department;
  }

  /**
   * setting the department
   *
   * @param department the department to set
   */
  public void setDepartment(Department department) {
    this.department = department;
  }

  /**
   * Get employee.
   *
   * @return the employee
   */
  public Employee getEmployee() {
    return employee;
  }

  /**
   * Setting the employee.
   *
   * @param employee the employee to set
   */
  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  /**
   * @param ticketId
   * @param ticketName
   * @param description
   * @param status
   * @param creationDate
   * @param lastUpdateDate
   * @param ticketType
   * @param department
   * @param employee
   * @param comments
   */public TicketDto(
    String ticketName,
    String description,
    TicketStatus status,
    TicketType ticketType,
    Department department,
    Employee employee
  ) {
    super();
    this.ticketName = ticketName;
    this.description = description;
    this.status = status;
    this.ticketType = ticketType;
    this.department = department;
    this.employee = employee;
  }

  /**
   *
   */public TicketDto() {
    super();
  }

  @Override
  public String toString() {
    return (
      "TicketDto [ticketName=" +
      ticketName +
      ", description=" +
      description +
      ", status=" +
      status +
      ", ticketType=" +
      ticketType +
      ", department=" +
      department +
      ", employee=" +
      employee +
      "]"
    );
  }
}
