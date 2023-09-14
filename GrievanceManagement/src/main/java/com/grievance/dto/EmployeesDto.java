package com.grievance.dto;

import com.grievance.entity.Department;
import com.grievance.entity.Role;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
  @Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq\\.com$",
      message = "Email should end with @nucleusteq.com")
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
   * @param name of string type .
   */
  public void setUserName(final String name) {
    this.userName = name;
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
   * @param em of string type.
   */
  public void setEmail(final String em) {
    this.email = em;
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
   * @param pass of String type.
   */
  public void setPassword(final String pass) {
    this.password = pass;
  }

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
   * @param ro of string type .
   */
  public void setRole(final Role ro) {
    this.role = ro;
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
   * @param dep of string type .
   */
  public void setDepartment(final Department dep) {
    this.department = dep;
  }

  /**
   * To string method.
   */
  @Override
  public String toString() {
    return (
      "EmployeesDto [maxPassword="
      +
      maxPassword
      +
      ", minPassword="
      +
      minPassword
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
   * Employee dto all Args constructor.
   *
   * @param name of type String
   * @param em of string type
   * @param pass of string type
   * @param ro of Role type
   * @param dep of Department type
   */
  public EmployeesDto(
      final @NotEmpty(message = "Username can not be null") String name,
      final @Email(message = "Email id not valid") String em,
      final @NotEmpty(message = "Password field is mendatory") @Size(
      min = minPassword,
      max = maxPassword,
      message = "password should be in range between 5 to 18"
    ) String pass,
      final Role ro,
      final @NotNull(message = "Department can not be null") Department dep
  ) {
    super();
    this.userName = name;
    this.email = em;
    this.password = pass;
    this.role = ro;
    this.department = dep;
  }

  /**
   * No Args Constructor .
   */
  public EmployeesDto() {
    super();
  }
}
