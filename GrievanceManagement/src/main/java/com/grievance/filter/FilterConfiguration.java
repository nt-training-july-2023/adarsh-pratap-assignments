package com.grievance.filter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.grievance.repo.EmployeeRepo;

@Configuration
public class FilterConfiguration {

  @Autowired
  EmployeeRepo employeeRepo;
  
  

  public FilterConfiguration(EmployeeRepo employeeRepo){super();this.employeeRepo=employeeRepo;}



  /**
   * 
   * @return
   */
  @Bean
  public FilterRegistrationBean<SecurityFilterAdmin> registrationBeanAdmin() {
	
    FilterRegistrationBean<SecurityFilterAdmin> registrationBean 
        = new FilterRegistrationBean<SecurityFilterAdmin>();
    registrationBean.setFilter(new SecurityFilterAdmin(employeeRepo));
    registrationBean.addUrlPatterns("/*");
    return registrationBean;
  }
 

}
