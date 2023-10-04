package com.grievance;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


/**
 * Main Class .
 */

@SpringBootApplication
public class GrievanceManagementApplication {

  /**
   * Main class .
   *
   * @param args
   *
   */
  public static void main(final String[] args) {
    SpringApplication.run(GrievanceManagementApplication.class, args);
  }

  /**
   * Model Mapper .
   *
   * @return Object of Model mapper.
   *
   */
  @Bean
  public ModelMapper getModelMapper() {
    return new ModelMapper();
  }
}
