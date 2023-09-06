package com.grievance.entity;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Ticket class.
 */
@Entity
public class Ticket {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer ticketId;

  @Column(name = "ticket_name" , nullable = false)
  private String ticketName;

  @Column(name = "discription")
  private String discription;

  @Enumerated(EnumType.STRING)
  private TicketStatus status;

  
  private Date creationDate;

  @Column(name = "last_update")
  private Date lastUpdateDate;

  @Column(name = "ticket_type")
  @Enumerated(EnumType.STRING)
  private TicketType ticketType;

  @ManyToOne
  @JoinColumn(name = "department_id")
  @JsonBackReference(value = "dep")
  private Department department;

  @ManyToOne
  @JoinColumn(name = "employee_id")
  @JsonBackReference(value = "emp")
  private Employee employee;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket", fetch = FetchType.LAZY)
  private List<Comment> comments;

  /**
   * @return the ticketId
   */
  public Integer getTicketId() {
    return ticketId;
  }

  /**
   * @param ticketId the ticketId to set
   */
  public void setTicketId(Integer ticketId) {
    this.ticketId = ticketId;
  }

  /**
   * @return the ticketName
   */
  public String getTicketName() {
    return ticketName;
  }

  /**
   * @param ticketName the ticketName to set
   */
  public void setTicketName(String ticketName) {
    this.ticketName = ticketName;
  }

  /**
   * @return the discription
   */
  public String getDiscription() {
    return discription;
  }

  /**
   * @param discription the discription to set
   */
  public void setDiscription(String discription) {
    this.discription = discription;
  }

  /**
   * @return the status
   */
  public TicketStatus getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(TicketStatus status) {
    this.status = status;
  }

  /**
   * @return the creationDate
   */
  public Date getCreationDate() {
    return creationDate;
  }

  /**
   * @param creationDate the creationDate to set
   */
  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  /**
   * @return the lastUpdateDate
   */
  public Date getLastUpdateDate() {
    return lastUpdateDate;
  }

  /**
   * @param lastUpdateDate the lastUpdateDate to set
   */
  public void setLastUpdateDate(Date lastUpdateDate) {
    this.lastUpdateDate = lastUpdateDate;
  }

  /**
   * @return the ticketType
   */
  public TicketType getTicketType() {
    return ticketType;
  }

  /**
   * @param ticketType the ticketType to set
   */
  public void setTicketType(TicketType ticketType) {
    this.ticketType = ticketType;
  }

  /**
   * @return the department
   */
  public Department getDepartment() {
    return department;
  }

  /**
   * @param department the department to set
   */
  public void setDepartment(Department department) {
    this.department = department;
  }

  /**
   * @return the employee
   */
  public Employee getEmployee() {
    return employee;
  }

  /**
   * @param employee the employee to set
   */
  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  /**
   * @return the comments
   */
  public List<Comment> getComments() {
    return comments;
  }

  /**
   * @param comments the comments to set
   */
  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }

public Ticket(Integer ticketId,String ticketName,String discription,TicketStatus status,Date creationDate,Date lastUpdateDate,TicketType ticketType,Department department,Employee employee,List<Comment> comments){super();this.ticketId=ticketId;this.ticketName=ticketName;this.discription=discription;this.status=status;this.creationDate=creationDate;this.lastUpdateDate=lastUpdateDate;this.ticketType=ticketType;this.department=department;this.employee=employee;this.comments=comments;}
  
public Ticket() {}
}
