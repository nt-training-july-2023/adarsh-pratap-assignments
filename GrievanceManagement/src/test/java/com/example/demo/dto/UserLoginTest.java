package com.example.demo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.dto.UserLogin;

public class UserLoginTest {
	
	UserLogin user ;
	
	@BeforeEach
	void setup() {
		user = new UserLogin("adarsh@gmail.com" , "adarsh");
	}
	
	@Test
	public void toString_Testing() {
		String value = "UserLogin [userName=adarsh@gmail.com, password=adarsh]";
		assertEquals(user.toString(), value);
	}
}

