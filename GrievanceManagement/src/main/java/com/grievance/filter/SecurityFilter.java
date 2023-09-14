package com.grievance.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grievance.entity.Role;
import com.grievance.repo.EmployeeRepo;

@Component
public class SecurityFilter implements Filter {
	
  @Autowired
  private EmployeeRepo employeeRepo;
  
  private static List<String> adminUrls = new ArrayList<String>();
  private static List<String> userUrls = new ArrayList<String>();
  
  static {
	  adminUrls.add("/department/getall");
	  userUrls.add("/employee/login");
  }

  public SecurityFilter(EmployeeRepo employeeRepo2){
	  this.employeeRepo = employeeRepo2;// TODO Auto-generated constructor stub}
  }

  public Boolean checkAdminUrl(String currentUrl) {
	  if(adminUrls.contains(currentUrl)) {
		  return true;
	  }
	  return false;
  }
  
  /**
   * Filter for urls.
   */
  @Override 
  public void doFilter(
        ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException,
        ServletException {
    
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    String email = httpServletRequest.getHeader("email");
    String password = httpServletRequest.getHeader("password");
    String currentUrl = httpServletRequest.getRequestURI();

    if (email == null || password == null) {
      ((HttpServletResponse) response).sendError(
          HttpServletResponse.SC_UNAUTHORIZED, "Invalid User");
    }
	
    else if (employeeRepo.existsByEmailAndPasswordAndRole(email , password , Role.ROLE_ADMIN) && checkAdminUrl(currentUrl)) {
    	
    	chain.doFilter(request, response);
		
	}
    
    else if (employeeRepo.existsByEmailAndPasswordAndRole(email , password , Role.ROLE_USER) && checkUserUrl(currentUrl)) {
    	
    	chain.doFilter(request, response);
		
	}
    else {
    	((HttpServletResponse) response).sendError(
				  HttpServletResponse.SC_UNAUTHORIZED,"Unauthorized User");
    }
}

  private boolean checkUserUrl(String currentUrl) {
	if(userUrls.contains(currentUrl)) {
		return true;
	}
	else {
		return false;
	}

  }



}

