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
public class EmployeesInDto {
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
   * Email of employee.
   */
  @Email(message = "Email id not valid")
  @Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq\\.com$",
      message = "Email should end with @nucleusteq.com")
  private String email;

  /**
   * Password of account .
   */
  @NotEmpty(message = "Password field is mandatory")
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
   * @param newUserName of string type .
   */
  public void setUserName(final String newUserName) {
    this.userName = newUserName;
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
   * @param newEmail of string type.
   */
  public void setEmail(final String newEmail) {
    this.email = newEmail;
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
   * @param newPassword of String type.
   */
  public void setPassword(final String newPassword) {
    this.password = newPassword;
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
   * @param newRole of string type .
   */
  public void setRole(final Role newRole) {
    this.role = newRole;
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
   * @param newDepartment of string type .
   */
  public void setDepartment(final Department newDepartment) {
    this.department = newDepartment;
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
   * @param newUserName of type String
   * @param newEmail of string type
   * @param newPassword of string type
   * @param newRole of Role type
   * @param newDepartment of Department type
   */
  public EmployeesInDto(
      final @NotEmpty(message = "Username can not be null") String newUserName,
      final @Email(message = "Email id not valid") String newEmail,
      final @NotEmpty(message = "Password field is mendatory") @Size(
      min = minPassword,
      max = maxPassword,
      message = "password should be in range between 5 to 18"
    ) String newPassword,
      final Role newRole,
      final @NotNull(message = "Department can not be null")
      Department newDepartment
  ) {
    super();
    this.userName = newUserName;
    this.email = newEmail;
    this.password = newPassword;
    this.role = newRole;
    this.department = newDepartment;
  }

  /**
   * No Args Constructor .
   */
  public EmployeesInDto() {
    super();
  }
}
