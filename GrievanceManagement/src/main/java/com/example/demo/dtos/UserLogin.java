package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User Login Object .
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserLogin {

  private String userName;
  
  private String password;
  
	
}
