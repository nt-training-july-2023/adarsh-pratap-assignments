package com.grievance.dto;

import com.grievance.entity.Department;
import javax.validation.constraints.NotEmpty;

public class DepartmentInDto {
  @NotEmpty(message = "Department name can not be empty")
  private String depName;

  /**
   * @return the depName
   */
  public String getDepName() {
    return depName;
  }

  /**
   * @param depName the depName to set
   */
  public void setDepName(String depName) {
    this.depName = depName;
  }

  @Override
  public String toString() {
    return "DepartmentInDto [depName=" + depName + "]";
  }

  public DepartmentInDto() {
    
  }

public DepartmentInDto(@NotEmpty(message="Department name can not be empty") String depName){super();this.depName=depName;}
  
  
}
