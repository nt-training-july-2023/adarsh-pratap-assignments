package com.example.demo.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Employee DTO .
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeesDto {
  private Integer empId;

  @NotEmpty(message = "Username can not be null")
  private String userName;

  @Email(message = "Email id not valid")
  private String email;

  @NotEmpty(message = "Password field is mendatory")
  @Size(min = 5, max = 18, message = "password should be in range between 5 to 18")
  private String password;

  private String role;

  @NotEmpty(message = "Department can not be null")
  private String department;
}
