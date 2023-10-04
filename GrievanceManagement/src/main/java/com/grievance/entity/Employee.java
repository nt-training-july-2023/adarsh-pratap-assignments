package com.grievance.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
   * @param newEmpId of type integer.
   */
  public void setEmpId(final Integer newEmpId) {
    this.empId = newEmpId;
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
  * @param newName of String.
  */
  public void setUserName(final String newName) {
    this.userName = newName;
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
   * @param newEmail of type String.
   */
  public void setEmail(final String newEmail) {
    this.email = newEmail;
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
   * @param newPassword of type string
   */
  public void setPassword(final String newPassword) {
    this.password = newPassword;
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
   * @param newRole of type Role
   */
  public void setRole(final Role newRole) {
    this.role = newRole;
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
   * @param newDepartment of type string
   */
  public void setDepartment(final Department newDepartment) {
    this.department = newDepartment;
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
   * @param newEmpId Integer
   *
   * @param newName String
   *
   * @param newEmail String
   *
   * @param newPassword String
   *
   * @param newRole Role
   *
   * @param newDepartment Department
   *
   */
  public Employee(
      final Integer newEmpId,
      final String newName,
      final String newEmail,
      final String newPassword,
      final Role newRole,
      final Department newDepartment
  ) {
    super();
    this.empId = newEmpId;
    this.userName = newName;
    this.email = newEmail;
    this.password = newPassword;
    this.role = newRole;
    this.department = newDepartment;
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
