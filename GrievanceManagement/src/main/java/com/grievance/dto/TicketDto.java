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

  @NotEmpty(message = "Discription is required filed")
  private String discription;

  private TicketStatus status;

//  @NotEmpty(message = "ticket type required")
  private TicketType ticketType;

//  @NotEmpty(message = "Required Field")
  @NotNull
  private Department department;

//  @NotEmpty(message = "Required Field")
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
   * @return the discription
   */
  public String getDiscription() {
    return discription;
  }

  /**
   * @param discription the discription to set
   */
  public void setDiscription(String discription) {
    this.discription = discription;
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
   * @param discription
   * @param status
   * @param creationDate
   * @param lastUpdateDate
   * @param ticketType
   * @param department
   * @param employee
   * @param comments
   */public TicketDto(
    String ticketName,
    String discription,
    TicketStatus status,
    TicketType ticketType,
    Department department,
    Employee employee
  ) {
    super();
    this.ticketName = ticketName;
    this.discription = discription;
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
      ", discription=" +
      discription +
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
