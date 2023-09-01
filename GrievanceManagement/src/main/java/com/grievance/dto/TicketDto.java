package com.grievance.dto;

import com.grievance.entity.Comment;
import com.grievance.entity.Department;
import com.grievance.entity.Employee;
import com.grievance.entity.TicketStatus;
import com.grievance.entity.TicketType;
import java.util.Date;
import java.util.List;

/**
 * Ticket DTO.
 */
public class TicketDto {
  private Integer ticketId;

  private String ticketName;

  private String discription;

  private TicketStatus status;

  private Date creationDate;

  private Date lastUpdateDate;

  private TicketType ticketType;

  private Department department;

  private Employee employee;

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
   * set TicketType.
   *
   * @param ticketType the ticketType to set
   */
  public void setTicketType(TicketType ticketType) {
    this.ticketType = ticketType;
  }

  /**
   * get Department.
   *
   * @return the department
   */
  public Department getDepartment() {
    return department;
  }

  /**
   * setting the department
   *
   * @param department the department to set
   */
  public void setDepartment(Department department) {
    this.department = department;
  }

  /**
   * Get employee.
   *
   * @return the employee
   */
  public Employee getEmployee() {
    return employee;
  }

  /**
   * Setting the employee.
   *
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

/**
 * @param ticketId
 * @param ticketName
 * @param discription
 * @param status
 * @param creationDate
 * @param lastUpdateDate
 * @param ticketType
 * @param department
 * @param employee
 * @param comments
 */public TicketDto(Integer ticketId,String ticketName,String discription,TicketStatus status,Date creationDate,Date lastUpdateDate,TicketType ticketType,Department department,Employee employee,List<Comment> comments){super();this.ticketId=ticketId;this.ticketName=ticketName;this.discription=discription;this.status=status;this.creationDate=creationDate;this.lastUpdateDate=lastUpdateDate;this.ticketType=ticketType;this.department=department;this.employee=employee;this.comments=comments;}

/**
 * 
 */public TicketDto(){super();}

@Override public String toString(){return "TicketDto [ticketId=" + ticketId + ", ticketName=" + ticketName + ", discription=" + discription + ", status=" + status + ", creationDate=" + creationDate + ", lastUpdateDate=" + lastUpdateDate + ", ticketType=" + ticketType + ", department=" + department + ", employee=" + employee + ", comments=" + comments + "]";}
  
  
}
