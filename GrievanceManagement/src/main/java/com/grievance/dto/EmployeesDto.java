package com.grievance.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.grievance.entity.Department;
import com.grievance.entity.Role;

/**
 * Employee DTO .
 */

public class EmployeesDto {

  /**
   * maximum size of password.
   */
  private final int maxPassword = 8;

  /**
   * minimum size of password.
   */
  private final int minPassword = 5;

  /**
   * Employee id .
   */
  private Integer empId;

  /**
   * Employee Name.
   */
  @NotEmpty(message = "Username can not be null")
  private String userName;

  /**
   * Email of employee .
   */
  @Email(message = "Email id not valid")
  private String email;

  /**
   * Password of account .
   */
  @NotEmpty(message = "Password field is mendatory")
  @Size(
      min = minPassword, max = maxPassword,
      message = "password should be in range between 5 to 18")
  private String password;

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
  @NotEmpty(message = "Department can not be null")
  private Department department;

  /**
   * getter for employee id .
   *
   * @return empId of type Integer .
   */
  public Integer getEmpId() {
    return empId;
  }

  /**
   * setter of employee id.
   *
   * @param empId of integer type .
   */
  public void setEmpId(final Integer empId) {
    this.empId = empId;
  }

  /**
   * Getter of user name .
   *
   * @return user name .
   */
  public String getUserName() {
    return userName;
  }

  /**
   * Setter of User Name .
   *
   * @param userName of string type .
   */
  public void setUserName(final String userName) {
    this.userName = userName;
  }

  /**
   * Getter of email .
   *
   * @return email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Setter of email .
   *
   * @param email of string type.
   */
  public void setEmail(final String email) {
    this.email = email;
  }

  /**
   * Getter of password .
   *
   * @return password.
   */
  public String getPassword() {
    return password;
  }

  /**
   * Setter of password .
   *
   * @param password of String type.
   */
  public void setPassword(final String password) {
    this.password = password;
  }
  
  /**
   * @return the isFirstLogin
   */
  public Boolean getIsFirstLogin() {
  return isFirstLogin;}

  /**
   * @param isFirstLogin the isFirstLogin to set
   */
  public void setIsFirstLogin(Boolean isFirstLogin) {
  this.isFirstLogin = isFirstLogin;}

  /**

  /**
   *Getter of Role.
   *
   * @return Role of string type .
   */
  public Role getRole() {
    return role;
  }

  /**
   * Setter for Role .
   *
   * @param role of string type .
   */
  public void setRole(final Role role) {
    this.role = role;
  }

  /**
   * Getter for Department .
   *
   * @return department of String type .
   */
  public Department getDepartment() {
    return department;
  }

  /**
   * setter for department .
   *
   * @param department of string type .
   */
  public void setDepartment(final Department department) {
    this.department = department;
  }

  /**
   * to string method .
   */
  @Override
  public String toString() {
    return (
      "EmployeesDto [empId="
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
      ", password="
      +
      password
      +
      ", role="
      +
      role
      +
      ", department="
      +
      department
      +
      "]"
      );
  }

  /**
   * Constructor .
   *
   * @param empId
   *
   * @param userName
   *
   * @param email
   *
   * @param password
   *
   * @param role
   *
   * @param department
   *
   */
  public EmployeesDto(
      final Integer empId,
      final @NotEmpty(message = "Username can not be null") String userName,
      final @Email(message = "Email id not valid") String email,
      final @NotEmpty(message = "Password field is mendatory") @Size(
      min = minPassword,
      max = maxPassword,
      message = "password should be in range between 5 to 18"
    ) String password,
      final Role role,
      final @NotEmpty(message = "Department can not be null") Department department
  ) {
    super();
    this.empId = empId;
    this.userName = userName;
    this.email = email;
    this.password = password;
    this.role = role;
    this.department = department;
  }

  /**
   * No Args Constructor .
   */
  public EmployeesDto() {
    super();
  }

}
