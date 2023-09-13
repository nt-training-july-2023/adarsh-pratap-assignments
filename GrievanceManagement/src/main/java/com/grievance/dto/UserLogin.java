package com.grievance.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


/**
 * User Login Object .
 */
public class UserLogin {

  /**
   * Email of Employee.
   */
  @Email(message = "Should be of email type")
  @Pattern(regexp = "^[A-Za-z0-9._%+-]+@nucleusteq\\.com$",
      message = "Email should end with @nucleusteq.com")
  private String userName;

  /**
   * password of employee.
   */
  @NotEmpty(message = "password can not be empty")
  private String password;

  /**
   * getter for username.
   *
   * @return userName of type String.
   */
  public String getUserName() {
    return userName;
  }

  /**
   * Setter for username.
   *
   * @param name of type String.
   */
  public void setUserName(final String name) {
    this.userName = name;
  }

  /**
   * getter for password.
   *
   * @return password of type string.
   */
  public String getPassword() {
    return password;
  }

  /**
   * Setter for password .
   *
   * @param pass of type String.
   */
  public void setPassword(final String pass) {
    this.password = pass;
  }

  /**
   * constructor.
   *
   * @param name String
   *
   * @param pass String
   *
   */
  public UserLogin(
      final @Email(message = "Should be of email type") String name,
      final @NotEmpty(message = "password can not be empty") String pass
  ) {
    super();
    this.userName = name;
    this.password = pass;
  }

  /**
   * NO args. Constructor.
   */
  public UserLogin() {
    super();
  }

  /**
   * to string method .
   */
  @Override
  public String toString() {
    return "UserLogin [userName=" + userName + ", password=" + password + "]";
  }
}
