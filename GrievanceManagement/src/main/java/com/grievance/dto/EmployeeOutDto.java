package com.grievance.dto;

import com.grievance.entity.Department;
import com.grievance.entity.Role;

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
   * @return the empId
   */
  public Integer getEmpId() {
    return empId;
  }

  /**
   * @param empId the empId to set
   */
  public void setEmpId(Integer empId) {
    this.empId = empId;
  }

  /**
   * @return the userName
   */
  public String getUserName() {
    return userName;
  }

  /**
   * @param userName the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the role
   */
  public Role getRole() {
    return role;
  }

  /**
   * @param role the role to set
   */
  public void setRole(Role role) {
    this.role = role;
  }

  /**
   * @return the isFirstLogin
   */
  public Boolean getIsFirstLogin() {
    return isFirstLogin;
  }

  /**
   * @param isFirstLogin the isFirstLogin to set
   */
  public void setIsFirstLogin(Boolean isFirstLogin) {
    this.isFirstLogin = isFirstLogin;
  }

  /**
   * @return the department
   */
  public Department getDepartment() {
    return department;
  }

  /**
   * @param department the department to set
   */
  public void setDepartment(Department department) {
    this.department = department;
  }

  /**
   *
   * @param empId
   * @param userName
   * @param email
   * @param role
   * @param isFirstLogin
   * @param department
   */
  public EmployeeOutDto(
    Integer empId,
    String userName,
    String email,
    Role role,
    Boolean isFirstLogin,
    Department department
  ) {
    super();
    this.empId = empId;
    this.userName = userName;
    this.email = email;
    this.role = role;
    this.isFirstLogin = isFirstLogin;
    this.department = department;
  }

  public EmployeeOutDto() {
    super();
  }

  @Override
  public String toString() {
    return (
      "EmployeeOutDto [empId=" +
      empId +
      ", userName=" +
      userName +
      ", email=" +
      email +
      ", role=" +
      role +
      ", isFirstLogin=" +
      isFirstLogin +
      ", department=" +
      department +
      "]"
    );
  }
}
