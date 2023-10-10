package com.grievance.dto;

import java.util.Objects;

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
   * @param newDepName the depName to set
   */
  public void setDepName(final String newDepName) {
    this.depName = newDepName;
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
  * @param newDepName of type String
  */
  public DepartmentInDto(
      final @NotEmpty(
      message = "Department name can not be empty") String newDepName) {
    super();
    this.depName = newDepName;
  }

  /**
   * Hash Code.
   */
  @Override
  public int hashCode() {
    return Objects.hash(depName);
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
    DepartmentInDto other = (DepartmentInDto) obj;
    return Objects.equals(depName, other.depName);
  }

}
