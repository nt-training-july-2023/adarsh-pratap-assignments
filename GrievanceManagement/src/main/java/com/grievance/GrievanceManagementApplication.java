package com.grievance;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;


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
  
  /**
   * Configure CORS settings.
   *
   * @return CorsConfigurationSource with CORS configuration.
   */
  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("*"));
    configuration.setAllowedMethods(
      Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")
    );
    configuration.setAllowedHeaders(Arrays.asList("http://localhost:3000"));
    configuration.setAllowCredentials(true);
    UrlBasedCorsConfigurationSource source =
         new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

}
