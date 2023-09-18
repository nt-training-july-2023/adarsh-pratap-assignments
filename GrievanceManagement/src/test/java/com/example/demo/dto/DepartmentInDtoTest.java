package com.example.demo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.dto.DepartmentInDto;

public class DepartmentInDtoTest {
	
	DepartmentInDto dep ;
	
	@BeforeEach
	public void setup() {
		dep = new DepartmentInDto("IT");
	}
	
	@Test
	public void toString_Testing() {
		String value = "DepartmentInDto [depName=IT]";
		assertEquals(dep.toString(), value);
	}
}

