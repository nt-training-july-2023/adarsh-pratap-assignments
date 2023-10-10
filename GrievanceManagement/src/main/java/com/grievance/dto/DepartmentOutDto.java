package com.grievance.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;

/**
 * Department Dto.
 */
public class DepartmentOutDto {
  /**
   * depId.
   */
  private Integer depId;

  /**
   * depName.
   */
  private String depName;

  /**
   * employee.
   */
  @JsonIgnore
  private List<EmployeeOutDto> employee;

  /**
   * ticket.
   */
  @JsonIgnore
  private List<TicketOutDto> ticket;

  /**
   * getter for depId.
   *
   * @return the depId
   */
  public Integer getDepId() {
    return depId;
  }

  /**
   * setter for depId.
   *
   * @param newDepId the depId to set
   */
  public void setDepId(final Integer newDepId) {
    this.depId = newDepId;
  }

  /**
   * getter for depName.
   *
   * @return the depName
   */
  public String getDepName() {
    return depName;
  }

  /**
   * setter for depName.
   *
   * @param newDepName the depName to set
   */
  public void setDepName(final String newDepName) {
    this.depName = newDepName;
  }

  /**
   * getter for employee.
   *
   * @return the employee
   */
  public List<EmployeeOutDto> getEmployee() {
    return employee;
  }

  /**
   * setter for employee.
   *
   * @param newEmployee the employee to set
   */
  public void setEmployee(final List<EmployeeOutDto> newEmployee) {
    this.employee = newEmployee;
  }

  /**
   * getter for ticket.
   *
   * @return the ticket
   */
  public List<TicketOutDto> getTicket() {
    return ticket;
  }

  /**
   * setter for ticket.
   *
   * @param newTicket the ticket to set
   */
  public void setTicket(final List<TicketOutDto> newTicket) {
    this.ticket = newTicket;
  }

  /**
   * all args constructor.
   *
   * @param newDepId Integer
   * @param newDepName String
   * @param newEmployee EmployeeOutDto
   * @param newTicket TicketOutDto
   */
  public DepartmentOutDto(
      final Integer newDepId,
      final @NotEmpty(
        message = "Department is a required field") String newDepName,
      final List<EmployeeOutDto> newEmployee,
      final List<TicketOutDto> newTicket
  ) {
    super();
    this.depId = newDepId;
    this.depName = newDepName;
    this.employee = newEmployee;
    this.ticket = newTicket;
  }

  /**
   * No args constructor.
   */
  public DepartmentOutDto() {
  }

  /**
   * to string method.
   */
  @Override
  public String toString() {
    return (
      "DepartmentOutDto [depId="
      + depId + ", depName="
      + depName + ", employee="
      + employee + ", ticket="
      + ticket + "]"
      );
  }

  /**
   * Hash Code Method.
   */
  @Override
  public int hashCode() {
    return Objects.hash(depId, depName, employee, ticket);
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
    DepartmentOutDto other = (DepartmentOutDto) obj;
    return Objects.equals(depId, other.depId)
        && Objects.equals(depName, other.depName)
        && Objects.equals(employee, other.employee)
        && Objects.equals(ticket, other.ticket);
  }
}
