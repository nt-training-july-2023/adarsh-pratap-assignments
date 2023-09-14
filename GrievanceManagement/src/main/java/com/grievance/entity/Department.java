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
   * @param id the depId to set
   */
  public void setDepId(final Integer id) {
    this.depId = id;
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
   * @param name the depName to set
   */
  public void setDepName(final String name) {
    this.depName = name;
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
   * @param emp the employee to set
   */
  public void setEmployee(final List<Employee> emp) {
    this.employee = emp;
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
   * @param tick the ticket to set
   */
  public void setTicket(final List<Ticket> tick) {
    this.ticket = tick;
  }

  /**
   * All args constructor.
   *
   * @param id of type Integer
   * @param name of type String
   * @param emp of type Employee
   * @param tick of type Ticket
   */
  public Department(
      final Integer id,
      final String name,
      final List<Employee> emp,
      final List<Ticket> tick
  ) {
    super();
    this.depId = id;
    this.depName = name;
    this.employee = emp;
    this.ticket = tick;
  }

  /**
   * No Args constructor.
   */
  public Department() {
    super();
  }
}
