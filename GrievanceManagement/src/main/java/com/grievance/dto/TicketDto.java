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
  /**
   * ticketName.
   */
  @NotEmpty(message = "Ticket name can not be empty")
  private String ticketName;

  /**
   * description.
   */
  @NotEmpty(message = "description is required filed")
  private String description;

  /**
   * status.
   */
  private TicketStatus status;

  /**
   * ticketType.
   */
  private TicketType ticketType;

  /**
   * department.
   */
  @NotNull
  private Department department;

  /**
   * employee.
   */
  @NotNull
  private Employee employee;

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
   * setter for description.
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
   * setter for status.
   *
   * @param stat the status to set.
   */
  public void setStatus(final TicketStatus stat) {
    this.status = stat;
  }

  /**
   * getter for type of ticket.
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
  public Department getDepartment() {
    return department;
  }

  /**
   * setting the department.
   *
   * @param dep the department to set
   */
  public void setDepartment(final Department dep) {
    this.department = dep;
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
   * @param emp the employee to set
   */
  public void setEmployee(final Employee emp) {
    this.employee = emp;
  }

  /**
   * All args constructor.
   *
   * @param name String
   * @param des String
   * @param stat TicketStatus
   * @param type TicketType
   * @param dep Department
   * @param emp Employee
   *
   */
  public TicketDto(
      final String name,
      final String des,
      final TicketStatus stat,
      final TicketType type,
      final Department dep,
      final Employee emp
  ) {
    super();
    this.ticketName = name;
    this.description = des;
    this.status = stat;
    this.ticketType = type;
    this.department = dep;
    this.employee = emp;
  }

  /**
  *No args constructor.
  */
  public TicketDto() {
    super();
  }

  /**
  * to string method.
  */
  @Override
  public String toString() {
    return (
      "TicketDto [ticketName="
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
      "]"
      );
  }
}
