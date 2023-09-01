package com.grievance.dto;

import com.grievance.entity.Employee;
import com.grievance.entity.Ticket;
import java.util.List;

/**
 * Department Dto.
 */
public class DepartmentDto {
  private Integer depId;

  private String depName;

  private List<Employee> employee;

  private List<Ticket> ticket;

  /**
   * @return the depId
   */
  public Integer getDepId() {
    return depId;
  }

  /**
   * @param depId the depId to set
   */
  public void setDepId(Integer depId) {
    this.depId = depId;
  }

  /**
   * @return the depName
   */
  public String getDepName() {
    return depName;
  }

  /**
   * @param depName the depName to set
   */
  public void setDepName(String depName) {
    this.depName = depName;
  }

  /**
   * @return the employee
   */
  public List<Employee> getEmployee() {
    return employee;
  }

  /**
   * @param employee the employee to set
   */
  public void setEmployee(List<Employee> employee) {
    this.employee = employee;
  }

  /**
   * @return the ticket
   */
  public List<Ticket> getTicket() {
    return ticket;
  }

  /**
   * @param ticket the ticket to set
   */
  public void setTicket(List<Ticket> ticket) {
    this.ticket = ticket;
  }
}
