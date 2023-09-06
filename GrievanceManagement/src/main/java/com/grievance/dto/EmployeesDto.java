package com.grievance.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.grievance.entity.Department;
import com.grievance.entity.Role;
import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Employee DTO .
 */
public class EmployeesDto {
  
  /**
   * maximum size of password.
   */
  private final int maxPassword = 15;

  /**
   * minimum size of password.
   */
  private final int minPassword = 5;

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
    min = minPassword,
    max = maxPassword,
    message = "password should be in range between 5 to 18"
  )
  private String password;

  /**
   * Role of employee .
   */
  private Role role;

  /**
   * Department of employee .
   */
  @NotNull(message = "Department can not be null")
  private Department department;

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

  @Override
  public String toString() {
    return (
      "EmployeesDto [maxPassword=" +
      maxPassword +
      ", minPassword=" +
      minPassword +
      ", userName=" +
      userName +
      ", email=" +
      email +
      ", password=" +
      password +
      ", role=" +
      role +
      ", department=" +
      department +
      "]"
    );
  }

  public EmployeesDto(
    @NotEmpty(message = "Username can not be null") String userName,
    @Email(message = "Email id not valid") String email,
    @NotEmpty(message = "Password field is mendatory") @Size(
      min = 5,
      max = 15,
      message = "password should be in range between 5 to 18"
    ) String password,
    Role role,
    @NotNull(message = "Department can not be null") Department department
  ) {
    super();
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
