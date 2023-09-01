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
  @Column(name = "dep_name")
  private String depName;

  /**
   * Employee mapping.
   */
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "department", fetch = FetchType.LAZY)
  @JsonManagedReference
  private List<Employee> employee;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "department", fetch = FetchType.LAZY)
  private List<Ticket> ticket;

  /**
   * @return the depId
   */
  public Integer getDepId() {
    return depId;
  }

  /**
   * @param depId the depId to set
   */
  public void setDepId(Integer depId) {
    this.depId = depId;
  }

  /**
   * @return the depName
   */
  public String getDepName() {
    return depName;
  }

  /**
   * @param depName the depName to set
   */
  public void setDepName(String depName) {
    this.depName = depName;
  }

  /**
   * @return the employee
   */
  public List<Employee> getEmployee() {
    return employee;
  }

  /**
   * @param employee the employee to set
   */
  public void setEmployee(List<Employee> employee) {
    this.employee = employee;
  }

  /**
   * @return the ticket
   */
  public List<Ticket> getTicket() {
    return ticket;
  }

  /**
   * @param ticket the ticket to set
   */
  public void setTicket(List<Ticket> ticket) {
    this.ticket = ticket;
  }

  public Department(
    Integer depId,
    String depName,
    List<Employee> employee,
    List<Ticket> ticket
  ) {
    super();
    this.depId = depId;
    this.depName = depName;
    this.employee = employee;
    this.ticket = ticket;
  }

  public Department() {
    super();
  }
}
