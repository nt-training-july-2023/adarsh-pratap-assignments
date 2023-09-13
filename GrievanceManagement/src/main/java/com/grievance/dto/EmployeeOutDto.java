package com.grievance.dto;

import java.util.List;

import com.grievance.entity.Department;
import com.grievance.entity.Role;
import com.grievance.entity.Ticket;

/**
 * Employee out Dto.
 */
public class EmployeeOutDto {
  /**
   * Employee id .
   */
  private Integer empId;

  /**
   * Employee Name.
   */
  private String userName;

  /**
   * Email of employee .
   */
  private String email;

  /**
   * Role of employee .
   */
  private Role role;

  /**
   * check if user logged in first time.
   */
  private Boolean isFirstLogin;

  /**
   * Department of employee .
   */
  private Department department;

  /**
   * Tickets.
   */
  private List<Ticket> ticket;

  /**
   * getter for empId.
   *
   * @return the empId
   */
  public Integer getEmpId() {
    return empId;
  }

  /**
   * setter for empId.
   *
   * @param id the empId to set
   */
  public void setEmpId(final Integer id) {
    this.empId = id;
  }

  /**
   * getter for userName.
   *
   * @return the userName
   */
  public String getUserName() {
    return userName;
  }

  /**
   * Setter for userName.
   *
   * @param name the userName to set
   */
  public void setUserName(final String name) {
    this.userName = name;
  }

  /**
   * getter for email.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * setter for email.
   *
   * @param em the email to set
   */
  public void setEmail(final String em) {
    this.email = em;
  }

  /**
   * getter for role.
   *
   * @return the role
   */
  public Role getRole() {
    return role;
  }

  /**
   * setter for role.
   *
   * @param ro the role to set
   */
  public void setRole(final Role ro) {
    this.role = ro;
  }

  /**
   * getter for isFirstLogin.
   *
   * @return the isFirst
   */
  public Boolean getIsFirstLogin() {
    return isFirstLogin;
  }

  /**
   * setter for isFirstLogin.
   *
   * @param isFirst the isFirstLogin to set
   */
  public void setIsFirstLogin(final Boolean isFirst) {
    this.isFirstLogin = isFirst;
  }

  /**
   * getter for department.
   *
   * @return the department
   */
  public Department getDepartment() {
    return department;
  }

  /**
   * setter for department.
   *
   * @param dep the department to set
   */
  public void setDepartment(final Department dep) {
    this.department = dep;
  }

  /**
   * getter for ticket.
   *
   * @return the List
   */
  public List<Ticket> getTicket() {
    return ticket;
  }

  /**
   * Setter for userName.
   *
   * @param tick List
   */
  public void setTicket(final List<Ticket> tick) {
    this.ticket = tick;
  }

  /**
   * All args constructor.
   *
   * @param id Integer.
   * @param name String
   * @param em String
   * @param ro string
   * @param isFirst boolean
   * @param dep Department
   * @param tick List
   */
  public EmployeeOutDto(
      final Integer id,
      final String name,
      final String em,
      final Role ro,
      final Boolean isFirst,
      final Department dep,
      final List<Ticket> tick
  ) {
    super();
    this.empId = id;
    this.userName = name;
    this.email = em;
    this.role = ro;
    this.isFirstLogin = isFirst;
    this.department = dep;
    this.ticket = tick;
  }

  /**
   * no args constructor.
   */
  public EmployeeOutDto() {
    super();
  }

  /**
   * to string method.
   */
  @Override
  public String toString() {
    return (
      "EmployeeOutDto [empId="
      +
      empId
      +
      ", userName="
      +
      userName
      +
      ", email="
      +
      email
      +
      ", role="
      +
      role
      +
      ", isFirstLogin="
      +
      isFirstLogin
      +
      ", department="
      +
      department
      +
      ", ticket="
      +
      ticket
      +
      "]"
      );
  }
}
