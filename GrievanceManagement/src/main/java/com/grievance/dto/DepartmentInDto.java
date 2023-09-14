package com.grievance.dto;

import javax.validation.constraints.NotEmpty;

/**
 * DepartmentInDto.
 */
public class DepartmentInDto {
  /**
   * depName.
   */
  @NotEmpty(message = "Department name can not be empty")
  private String depName;

  /**
   * Getter for DepName.
   *
   * @return the depName
   */
  public String getDepName() {
    return depName;
  }

  /**
   *Setter for DepName.
   *
   * @param name the depName to set
   */
  public void setDepName(final String name) {
    this.depName = name;
  }

  /**
   * To string method.
   */
  @Override
  public String toString() {
    return "DepartmentInDto [depName=" + depName + "]";
  }

  /**
   * No args constructor.
   */
  public DepartmentInDto() {
  }

  /**
  *All args COnstructor.
  *
  * @param name of type String
  */
  public DepartmentInDto(
      final @NotEmpty(
      message = "Department name can not be empty") String name) {
    super();
    this.depName = name;
  }
}
