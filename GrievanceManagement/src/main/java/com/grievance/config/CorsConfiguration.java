package com.grievance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

  @Bean
  public WebMvcConfigurer addCorsConfigurer() {
    return new WebMvcConfigurer() {

      public void addCorsMapping(CorsRegistry registry) {
        registry
          .addMapping("/**")
          .allowedMethods("*")
          .allowedHeaders("*")
          .allowedOrigins("*");
      }
    };
  }
}
