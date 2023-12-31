package com.grievance.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grievance.entity.Role;
import java.util.List;
import java.util.Objects;


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
  @JsonIgnore
  private DepartmentOutDto department;

  /**
   * DepName.
   */
  private String depName;

  /**
   * Tickets Out Dto.
   */
  @JsonIgnore
  private List<TicketOutDto> ticket;

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
   * @param newEmpId the empId to set
   */
  public void setEmpId(final Integer newEmpId) {
    this.empId = newEmpId;
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
   * @param newUserName the userName to set
   */
  public void setUserName(final String newUserName) {
    this.userName = newUserName;
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
   * @param newEmail the email to set
   */
  public void setEmail(final String newEmail) {
    this.email = newEmail;
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
   * @param newRole the role to set
   */
  public void setRole(final Role newRole) {
    this.role = newRole;
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
   * @param newIsFirstLogin the isFirstLogin to set
   */
  public void setIsFirstLogin(final Boolean newIsFirstLogin) {
    this.isFirstLogin = newIsFirstLogin;
  }

  /**
   * getter for department.
   *
   * @return the department
   */
  public DepartmentOutDto getDepartment() {
    return department;
  }

  /**
   * setter for department.
   *
   * @param newDepartment the department to set
   */
  public void setDepartment(final DepartmentOutDto newDepartment) {
    this.department = newDepartment;
  }

  /**
   * getter for ticket.
   *
   * @return the List
   */
  public List<TicketOutDto> getTicket() {
    return ticket;
  }

  /**
   * Setter for userName.
   *
   * @param newTicket List
   */
  public void setTicket(final List<TicketOutDto> newTicket) {
    this.ticket = newTicket;
  }

  /**
  *Getter for DepName.
  *
  * @return the depName
  */
  public String getDepName() {
    return depName;
  }

  /**
  * Setter for DepName.
  *
  * @param newDepName the depName to set
  */
  public void setDepName(final String newDepName) {
    this.depName = newDepName;
  }

  /**
   * All args constructor.
   *
   * @param newEmpId Integer.
   * @param newUserName String
   * @param newEmail String
   * @param newRole string
   * @param newIsFirstLogin boolean
   * @param newDepartment Department
   * @param newTicket List
   */
  public EmployeeOutDto(
      final Integer newEmpId,
      final String newUserName,
      final String newEmail,
      final Role newRole,
      final Boolean newIsFirstLogin,
      final DepartmentOutDto newDepartment,
      final List<TicketOutDto> newTicket
  ) {
    super();
    this.empId = newEmpId;
    this.userName = newUserName;
    this.email = newEmail;
    this.role = newRole;
    this.isFirstLogin = newIsFirstLogin;
    this.department = newDepartment;
    this.ticket = newTicket;
  }

  /**
   * Hash Code.
   */
  @Override
  public int hashCode() {
    return Objects.hash(
        depName, department, email, empId,
        isFirstLogin, role, ticket, userName);
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
    EmployeeOutDto other = (EmployeeOutDto) obj;
    return Objects.equals(depName, other.depName)
        && Objects.equals(department, other.department)
        && Objects.equals(email, other.email)
        && Objects.equals(empId, other.empId)
        && Objects.equals(isFirstLogin, other.isFirstLogin)
        && role == other.role && Objects.equals(ticket, other.ticket)
        && Objects.equals(userName, other.userName);
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
