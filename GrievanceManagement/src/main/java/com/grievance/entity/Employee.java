package com.grievance.entity;

import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonBackReference;


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
  @Column(name = "username" , nullable = false)
  private String userName;

  /**
   * email of employee.
   */
  @Column(name = "email", unique = true)
  private String email;

  /**
   * password of employee .
   */
  @Column(name = "password" , nullable = false)
  private String password;
  
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
  
  @OneToMany(cascade = CascadeType.ALL , mappedBy = "employee" , fetch = FetchType.LAZY)
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
   * @param empId of type integer.
   */
  public void setEmpId(final Integer empId) {
    this.empId = empId;
  }

  /**
   * Getter of username.
   *
   * @return String type username.
   */
  public String getUserName() {
    return userName;
  }

  /**
  * Setter of password.
  *
  * @param userName of String.
  */
  public void setUserName(final String userName) {
    this.userName = userName;
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
   * @param email of type String.
   */
  public void setEmail(final String email) {
    this.email = email;
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
   * @param password of type string
   */
  public void setPassword(final String password) {
    this.password = password;
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
   * @param role of type Role
   */
  public void setRole(final Role role) {
    this.role = role;
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
   * @param department of type string
   */
  public void setDepartment(final Department department) {
    this.department = department;
  }
  
  /**
   * @return the isFirstLogin
   */
  public Boolean getIsFirstLogin() {
  return isFirstLogin;}

  /**
   * @param isFirstLogin the isFirstLogin to set
   */
  public void setIsFirstLogin(Boolean isFirstLogin) {
  this.isFirstLogin = isFirstLogin;}

  /**
   * @return the ticket
   */
  public List<Ticket> getTicket() {
  return ticket;}

  /**
   * @param ticket the ticket to set
   */
  public void setTicket(List<Ticket> ticket) {
  this.ticket = ticket;}


  /**
   * Employee Constructor .
   *
   * @param empId
   *
   * @param userName
   *
   * @param email
   *
   * @param password
   *
   * @param role
   *
   * @param department
   *
   */
  public Employee(
      final Integer empId,
      final String userName,
      final String email,
      final String password,
      final Role role,
      final Department department
  ) {
    super();
    this.empId = empId;
    this.userName = userName;
    this.email = email;
    this.password = password;
    this.role = role;
    this.department = department;
  }

  /**
   * No argument constructor .
   */
  public Employee() {
    super();
  }

  /**
   * To string method .
   */
  @Override
  public String toString() {
    return (
      "Employees [empId="
      +
      empId
      +
      ", userName="
      +
      userName
      +
      ", email="
      +
      email
      +
      ", password="
      +
      password
      +
      ", role="
      +
      role
      +
      ", department="
      +
      department
      +
      "]"
      );
  }
}
