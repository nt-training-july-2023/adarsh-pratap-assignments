package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Entity for Employees .
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employees {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer empId;

  
  private String userName;

  
  private String email;
	
  private String password;

  
  private String role;
  
  private String department;
	

}
