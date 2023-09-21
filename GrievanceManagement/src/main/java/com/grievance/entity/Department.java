package com.grievance.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Department class.
 */
@Entity
public class Department {
  /**
   * Department Id.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer depId;

  /**
   * Department name .
   */
  @Column(name = "dep_name", unique = true)
  private String depName;

  /**
   * Employee mapping.
   */
  @OneToMany(cascade = CascadeType.ALL,
      mappedBy = "department", fetch = FetchType.LAZY)
  @JsonManagedReference
  private List<Employee> employee;

  /**
   * List of Ticket.
   */
  @OneToMany(cascade = CascadeType.ALL,
      mappedBy = "department", fetch = FetchType.LAZY)
  @JsonManagedReference(value = "dep")
  private List<Ticket> ticket;

  /**
   * getter for DepId.
   *
   * @return the depId
   */
  public Integer getDepId() {
    return depId;
  }

  /**
   * setter for DepID.
   *
   * @param newDepId the depId to set
   */
  public void setDepId(final Integer newDepId) {
    this.depId = newDepId;
  }

  /**
   * Getter for depName.
   *
   * @return the depName
   */
  public String getDepName() {
    return depName;
  }

  /**
   * setter for depName.
   *
   * @param newDeapName the depName to set
   */
  public void setDepName(final String newDeapName) {
    this.depName = newDeapName;
  }

  /**
   * getter for employee.
   *
   * @return the employee
   */
  public List<Employee> getEmployee() {
    return employee;
  }

  /**
   * setter for employee.
   *
   * @param newEmployee the employee to set
   */
  public void setEmployee(final List<Employee> newEmployee) {
    this.employee = newEmployee;
  }

  /**
   * getter for ticket.
   *
   * @return the ticket
   */
  public List<Ticket> getTicket() {
    return ticket;
  }

  /**
   * setter for set ticket.
   *
   * @param newTicket the ticket to set
   */
  public void setTicket(final List<Ticket> newTicket) {
    this.ticket = newTicket;
  }

  /**
   * All args constructor.
   *
   * @param newDepId of type Integer
   * @param newDeapName of type String
   * @param newEmployee of type Employee
   * @param newTicket of type Ticket
   */
  public Department(
      final Integer newDepId,
      final String newDeapName,
      final List<Employee> newEmployee,
      final List<Ticket> newTicket
  ) {
    super();
    this.depId = newDepId;
    this.depName = newDeapName;
    this.employee = newEmployee;
    this.ticket = newTicket;
  }

  /**
   * No Args constructor.
   */
  public Department() {
    super();
  }  
  
}
