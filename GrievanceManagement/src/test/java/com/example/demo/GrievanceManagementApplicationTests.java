package com.example.demo;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import com.grievance.GrievanceManagementApplication;

@SpringBootTest
@SpringBootConfiguration
class GrievanceManagementApplicationTests {

	private GrievanceManagementApplication application;

    @BeforeEach
    public void setUp() {
        application = new GrievanceManagementApplication();
    }

    @Test
    public void testGetModelMapper() {
        ModelMapper modelMapper = application.getModelMapper();
        assertNotNull(modelMapper);
    }
}

