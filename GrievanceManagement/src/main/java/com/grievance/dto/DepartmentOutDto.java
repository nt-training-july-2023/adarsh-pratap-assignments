package com.grievance.dto;

import com.grievance.entity.Employee;
import com.grievance.entity.Ticket;
import java.util.List;
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
  private List<Employee> employee;

  /**
   * ticket.
   */
  private List<Ticket> ticket;

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
   * @param id the depId to set
   */
  public void setDepId(final Integer id) {
    this.depId = id;
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
   * @param name the depName to set
   */
  public void setDepName(final String name) {
    this.depName = name;
  }

  /**
   * getter for employee.
   *
   * @return the employee
   */
  public List<Employee> getEmployee() {
    return employee;
  }

  /**
   * setter for employee.
   *
   * @param emp the employee to set
   */
  public void setEmployee(final List<Employee> emp) {
    this.employee = emp;
  }

  /**
   * getter for ticket.
   *
   * @return the ticket
   */
  public List<Ticket> getTicket() {
    return ticket;
  }

  /**
   * setter for ticket.
   *
   * @param tick the ticket to set
   */
  public void setTicket(final List<Ticket> tick) {
    this.ticket = tick;
  }

  /**
   * all args constructor.
   *
   * @param id Integer
   * @param name String
   * @param emp Employee
   * @param tick Ticket
   */
  public DepartmentOutDto(
      final Integer id,
      final @NotEmpty(message = "Department is a required field") String name,
      final List<Employee> emp,
      final List<Ticket> tick
  ) {
    super();
    this.depId = id;
    this.depName = name;
    this.employee = emp;
    this.ticket = tick;
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
      +
      depId
      +
      ", depName="
      +
      depName
      +
      ", employee="
      +
      employee
      +
      ", ticket="
      +
      ticket
      +
      "]"
      );
  }
}
