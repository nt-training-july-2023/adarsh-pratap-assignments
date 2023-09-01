package com.grievance.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


/**
 * User Login Object .
 */

public class UserLogin {

  /**
   * Email of Employee.
   */
  @Email(message = "Should be of email type")
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
   * @param userName of type String.
   */
  public void setUserName(final String userName) {
    this.userName = userName;
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
   * @param password of type String.
   */
  public void setPassword(final String password) {
    this.password = password;
  }

  /**
   * constructor.
   *
   * @param userName
   *
   * @param password
   *
   */
  public UserLogin(
      final @Email(message = "Should be of email type") String userName,
      final @NotEmpty(message = "password can not be empty") String password
  ) {
    super();
    this.userName = userName;
    this.password = password;
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
