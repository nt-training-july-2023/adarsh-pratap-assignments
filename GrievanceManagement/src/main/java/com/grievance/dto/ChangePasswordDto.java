package com.grievance.dto;

/**
 * Change Password Dto.
 */
public class ChangePasswordDto {
  /**
   * old password.
   */
  private String oldPassword;

  /**
   * new password.
   */
  private String newPassword;

  /**
   * confirm password.
   */
  private String confirmPassword;

  /**
   * getter for old password.
   *
   * @return the oldPassword
   */
  public String getOldPassword() {
    return oldPassword;
  }

  /**
   * setter for old password.
   *
   * @param old the oldPassword to set
   */
  public void setOldPassword(final String old) {
    this.oldPassword = old;
  }

  /**
   * getter for new password.
   *
   * @return the newPassword
   */
  public String getNewPassword() {
    return newPassword;
  }

  /**
   * setter for new Password.
   *
   * @param newPass the newPassword to set
   */
  public void setNewPassword(final String newPass) {
    this.newPassword = newPass;
  }

  /**
   * getter confirm password.
   *
   * @return the confirmPassword
   */
  public String getConfirmPassword() {
    return confirmPassword;
  }

  /**
   * setter for confirm password.
   *
   * @param confirmPass the confirmPassword to set
   */
  public void setConfirmPassword(final String confirmPass) {
    this.confirmPassword = confirmPass;
  }

  /**
   * All args constructor.
   *
   * @param old String
   * @param newPass String
   * @param confirmPass String
   */
  public ChangePasswordDto(
      final String old,
      final String newPass,
      final String confirmPass
  ) {
    super();
    this.oldPassword = old;
    this.newPassword = newPass;
    this.confirmPassword = confirmPass;
  }

  /**
   * No args constructor.
   */
  public ChangePasswordDto() {
  }
}
