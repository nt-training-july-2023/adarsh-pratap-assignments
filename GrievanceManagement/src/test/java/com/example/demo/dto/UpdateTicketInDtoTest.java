package com.example.demo.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grievance.dto.UpdateTicketInDto;

public class UpdateTicketInDtoTest {
	
	UpdateTicketInDto updateTicketInDto;
	
	@BeforeEach
	void setup() {
		updateTicketInDto = new UpdateTicketInDto();
		updateTicketInDto.setEmpName("Adarsh");
	}
	
	@Test
	void settergetter(){
		org.junit.jupiter.api.Assertions.assertEquals("Adarsh", updateTicketInDto.getEmpName());
	}
}

