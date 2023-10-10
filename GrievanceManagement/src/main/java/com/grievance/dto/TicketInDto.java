package com.grievance.dto;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.grievance.entity.Department;
import com.grievance.entity.Employee;
import com.grievance.entity.TicketStatus;
import com.grievance.entity.TicketType;

/**
 * Ticket In DTO.
 */
public class TicketInDto {
  /**
   * ticketName.
   */
  @NotEmpty(message = "Ticket newDescription can not be empty")
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
   * setter for status.
   *
   * @param newStatus the status to set.
   */
  public void setStatus(final TicketStatus newStatus) {
    this.status = newStatus;
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
   * @param newTicketType the newTicketTypeetType to set
   */
  public void setTicketType(final TicketType newTicketType) {
    this.ticketType = newTicketType;
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
   * @param newDepartment the department to set
   */
  public void setDepartment(final Department newDepartment) {
    this.department = newDepartment;
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
   * @param newEmployee the employee to set
   */
  public void setEmployee(final Employee newEmployee) {
    this.employee = newEmployee;
  }

  /**
   * All args constructor.
   *
   * @param newTicketName String
   * @param newDescription String
   * @param newStatus TicketStatus
   * @param newTicketType TicketType
   * @param newDepartment Department
   * @param newEmployee Employee
   *
   */
  public TicketInDto(
      final String newTicketName,
      final String newDescription,
      final TicketStatus newStatus,
      final TicketType newTicketType,
      final Department newDepartment,
      final Employee newEmployee
  ) {
    super();
    this.ticketName = newTicketName;
    this.description = newDescription;
    this.status = newStatus;
    this.ticketType = newTicketType;
    this.department = newDepartment;
    this.employee = newEmployee;
  }

  /**
  *No args constructor.
  */
  public TicketInDto() {
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

  /**
   * Hash Code.
   */
  @Override
  public int hashCode() {
    return Objects.hash(
        description, status, ticketName, ticketType);
  }

  /**
   * Equals Method.
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
    TicketInDto other = (TicketInDto) obj;
    return Objects.equals(description, other.description)
        && status == other.status
        && Objects.equals(ticketName, other.ticketName)
        && ticketType == other.ticketType;
  }
}

