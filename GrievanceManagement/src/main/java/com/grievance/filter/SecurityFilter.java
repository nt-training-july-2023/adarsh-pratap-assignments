package com.grievance.filter;

import com.grievance.entity.Role;
import com.grievance.repo.EmployeeRepo;
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



/**
 * Security Filter class.
 */

@Component
public class SecurityFilter implements Filter {
  /**
   * Employee Repository Autowired.
   */
  @Autowired
  private EmployeeRepo employeeRepo;

  /**
   * List to store Admin URLS.
   */
  private static List<String> adminUrls = new ArrayList<String>();

  static {
    adminUrls.add("/department/add");
    adminUrls.add("/employee/add");
    adminUrls.add("/employee/getall");
  }

  /**
   * Constructor.
   *
   * @param employeeRepo2 Employee Repository
   */
  public SecurityFilter(final EmployeeRepo employeeRepo2) {
    this.employeeRepo = employeeRepo2;
  }

  /**
   * Check if URL is in the ADMIN URLS or not.
   *
   * @param currentUrl String
   * @return Boolean
   */
  public Boolean checkAdminUrl(final String currentUrl) {
    if (adminUrls.contains(currentUrl)) {
      return true;
    }
    return false;
  }

  /**
   * Filter.
   */
  @Override
  public void doFilter(
      final ServletRequest request,
      final ServletResponse response,
      final FilterChain chain
  )
      throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;

    String email = httpServletRequest.getHeader("email");
    String password = httpServletRequest.getHeader("password");
    String currentUrl = httpServletRequest.getRequestURI();
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;

    if (currentUrl.equals("/employee/login")) {
      chain.doFilter(request, response);
    } else if (httpServletRequest.getMethod().equals("OPTIONS")) {
      httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
      httpServletResponse.setHeader(
           "Access-Control-Allow-Methods",
           "GET, POST, PUT, DELETE"
      );
      httpServletResponse.setHeader(
          "Access-Control-Allow-Headers",
          "Authorization, Content-Type, email, password"
      );
      httpServletResponse.setContentType("application/json");
      httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    } else {

      if (email == null || password == null) {
        ((HttpServletResponse) response).sendError(
            HttpServletResponse.SC_UNAUTHORIZED,
            "Invalid User"
        );
      } else if (
          employeeRepo.existsByEmailAndPasswordAndRole(
            email, password, Role.ROLE_ADMIN)
          && checkAdminUrl(currentUrl)
      ) {
        chain.doFilter(request, response);
      } else if (
          employeeRepo.existsByEmailAndPassword(email, password)
          && !(checkAdminUrl(currentUrl))
      ) {
        chain.doFilter(request, response);
      } else {
        ((HttpServletResponse) response).sendError(
            HttpServletResponse.SC_UNAUTHORIZED,
            "Unauthorized User"
        );
      }
    }
  }
}
