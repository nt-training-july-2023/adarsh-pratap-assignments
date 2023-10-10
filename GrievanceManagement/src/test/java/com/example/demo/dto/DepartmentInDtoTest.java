package com.example.demo.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
	
	@Test
	public void hashCodeTest() {
		DepartmentInDto dep1 = new DepartmentInDto();
		dep1.setDepName("IT");
		
		DepartmentInDto dep2 = new DepartmentInDto();
		dep2.setDepName("IT");
		
		DepartmentInDto dep3 = new DepartmentInDto();
		dep3.setDepName("HR");
		
		assertEquals(dep1.hashCode(), dep2.hashCode());
		assertNotEquals(dep1.hashCode(), dep3.hashCode());
	}
	
	@Test
	public void equalsTesting() {
		DepartmentInDto dep1 = new DepartmentInDto();
		dep1.setDepName("IT");
		
		DepartmentInDto dep2 = new DepartmentInDto();
		dep2.setDepName("IT");
		
		DepartmentInDto dep3 = new DepartmentInDto();
		dep3.setDepName("HR");
		
		Department dep = new Department();
		assertThat(dep1.equals(dep2));
		assertThat(dep1.equals(dep3));
		assertThat(dep1.equals(dep1));
		assertThat(dep1.equals(null));
		assertThat(dep1.equals(dep));
	}
}

