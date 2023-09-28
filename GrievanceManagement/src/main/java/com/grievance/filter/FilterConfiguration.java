package com.grievance.filter;

import com.grievance.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;



/**
 * Security Filter Configuration.
 *
 * @author adarsh
 */
@Configuration
public class FilterConfiguration {
  /**
   * Autowired EmployeeRepo.
   */
  @Autowired
  private EmployeeRepo employeeRepo;

  /**
   * Constructor.
   *
   * @param newEmployeeRepo EmployeeRepo
   */
  public FilterConfiguration(final EmployeeRepo newEmployeeRepo) {
    super();
    this.employeeRepo = newEmployeeRepo;
  }

  /**
   * CORS FILTER.
   *
   * @return CorsFilter
   */
  @Bean
  public CorsFilter corsFilter() {
    final UrlBasedCorsConfigurationSource source =
        new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    config.addAllowedOrigin("http://localhost:3000");
    config.addAllowedHeader("*");
    config.addAllowedMethod("GET");
    config.addAllowedMethod("POST");
    config.addAllowedMethod("PUT");
    config.addAllowedMethod("DELETE");

    source.registerCorsConfiguration("/**", config);

    return new CorsFilter(source);
  }

  /**
   * Security Filter Configuration.
   *
   * @return FilterRegistrationBean
   */
  @Bean
  @DependsOn("corsFilter")
  FilterRegistrationBean<SecurityFilter> registrationBeanAdmin() {
    FilterRegistrationBean<SecurityFilter> registrationBean =
        new FilterRegistrationBean<SecurityFilter>();
    registrationBean.setFilter(new SecurityFilter(employeeRepo));
    registrationBean.addUrlPatterns("/*");
    return registrationBean;
  }
}
