package com.grievance.dto;

import java.util.Objects;

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
   * @param newOldPassword the oldPassword to set
   */
  public void setOldPassword(final String newOldPassword) {
    this.oldPassword = newOldPassword;
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
   * @param newNewPassword the newPassword to set
   */
  public void setNewPassword(final String newNewPassword) {
    this.newPassword = newNewPassword;
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
   * @param newConfirmPassword the confirmPassword to set
   */
  public void setConfirmPassword(final String newConfirmPassword) {
    this.confirmPassword = newConfirmPassword;
  }

  /**
   * All args constructor.
   *
   * @param newOldPassword String
   * @param newNewPassword String
   * @param newConfirmPassword String
   */
  public ChangePasswordDto(
      final String newOldPassword,
      final String newNewPassword,
      final String newConfirmPassword
  ) {
    super();
    this.oldPassword = newOldPassword;
    this.newPassword = newNewPassword;
    this.confirmPassword = newConfirmPassword;
  }

  /**
   * No args constructor.
   */
  public ChangePasswordDto() {
  }

  /**
   * Hash Code.
   */
  @Override
  public int hashCode() {
    return Objects.hash(
        confirmPassword, newPassword, oldPassword);
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
    ChangePasswordDto other = (ChangePasswordDto) obj;
    return Objects.equals(confirmPassword, other.confirmPassword)
        && Objects.equals(newPassword, other.newPassword)
        && Objects.equals(oldPassword, other.oldPassword);
  }
}

