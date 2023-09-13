package com.grievance.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * Entity for Employees .
 */

@Entity
public class Employee {

  /**
   * Employee Id.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "emp_id")
  private Integer empId;

  /**
   * User name of employee.
   */
  @Column(name = "username", nullable = false)
  private String userName;

  /**
   * email of employee.
   */
  @Column(name = "email", unique = true)
  private String email;

  /**
   * password of employee .
   */
  @Column(name = "password", nullable = false)
  private String password;

  /**
   * IsFirstLogin.
   */
  @Column(name = "is_first_login")
  private Boolean isFirstLogin;


  /**
   * Roles of employee field.
   */
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Role role;

  /**
   * Department field.
   */
  @ManyToOne
  @JoinColumn(name = "department_id")
  @JsonBackReference
  private Department department;

  /**
   * Ticket.
   */
  @OneToMany(
      cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
  @JsonManagedReference(value = "emp")
  private List<Ticket> ticket;

  /**
   * getter for employee.
   *
   * @return empId of type Integer.
   */
  public Integer getEmpId() {
    return empId;
  }

  /**
   *Set employee.
   *
   * @param id of type integer.
   */
  public void setEmpId(final Integer id) {
    this.empId = id;
  }

  /**
   * Getter of userName.
   *
   * @return String type userName.
   */
  public String getUserName() {
    return userName;
  }

  /**
  * Setter of password.
  *
  * @param name of String.
  */
  public void setUserName(final String name) {
    this.userName = name;
  }

  /**
  * Getter for email.
  *
  * @return email.
  */
  public String getEmail() {
    return email;
  }

  /**
   * Setter of email.
   *
   * @param em of type String.
   */
  public void setEmail(final String em) {
    this.email = em;
  }

  /**
   * Getter of password.
   *
   * @return String type password.
   */
  public String getPassword() {
    return password;
  }

  /**
   * Setter for password .
   *
   * @param pass of type string
   */
  public void setPassword(final String pass) {
    this.password = pass;
  }

  /**
   * Getter for Role.
   *
   * @return Role of type Enum.
   */
  public Role getRole() {
    return role;
  }

  /**
   * Setter for Role .
   *
   * @param ro of type Role
   */
  public void setRole(final Role ro) {
    this.role = ro;
  }

  /**
   * Get Department .
   *
   * @return Department.
   */
  public Department getDepartment() {
    return department;
  }

  /**
   * Setter for Department.
   *
   * @param dep of type string
   */
  public void setDepartment(final Department dep) {
    this.department = dep;
  }

  /**
   * getter for IsFirstLogin.
   *
   * @return the isFirstLogin
   */
  public Boolean getIsFirstLogin() {
    return isFirstLogin;
  }

  /**
   *setter for is isFirstLogin.
   *
   * @param isFirstLog the isFirstLogin to set
   */
  public void setIsFirstLogin(final Boolean isFirstLog) {
    this.isFirstLogin = isFirstLog;
  }

  /**
   * getter for getTicket.
   *
   * @return the ticket
   */
  public List<Ticket> getTicket() {
    return ticket;
  }

  /**
   * setter for ticket.
   *
   * @param tick the ticket to set
   */
  public void setTicket(final List<Ticket> tick) {
    this.ticket = tick;
  }


  /**
   * Employee Constructor .
   *
   * @param id Integer
   *
   * @param name String
   *
   * @param em String
   *
   * @param pass String
   *
   * @param ro Role
   *
   * @param dep Department
   *
   */
  public Employee(
      final Integer id,
      final String name,
      final String em,
      final String pass,
      final Role ro,
      final Department dep
  ) {
    super();
    this.empId = id;
    this.userName = name;
    this.email = em;
    this.password = pass;
    this.role = ro;
    this.department = dep;
  }

  /**
   * No argument constructor .
   */
  public Employee() {
    super();
  }

  /**
  * to string method.
  */
  @Override
  public String toString() {
    return "Employee [empId=" + empId + ", userName="
      + userName + ", email=" + email + ","
      + " password=" + password + ", isFirstLogin="
      +
      isFirstLogin + ", role=" + role + ", department="
      + department + ", ticket=" + ticket + "]";
  }

}
