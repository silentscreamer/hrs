package com.example.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.example.dto.BaseDto;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class LeaveDetail extends BaseDto {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long leaveDetailId;

  @OneToOne
  @JoinColumn(name = "user_id")
  @JsonBackReference
  private User user;

  @NotNull
  private int numOfEarnedLeaves;
  @NotNull
  private int numOfCasualLeaves;
  @NotNull
  private int numOfSickLeaves;

  @Column(name = "created_on", nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  private Date createdOn;
  @Column(name = "created_by")
  private int createdBy;
  @Column(name = "updated_on", nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  private Date updatedOn;
  private int updated_by;

  public int getNumOfEarnedLeaves() {
    return numOfEarnedLeaves;
  }

  public void setNumOfEarnedLeaves(int numOfEarnedLeaves) {
    this.numOfEarnedLeaves = numOfEarnedLeaves;
  }

  public int getNumOfCasualLeaves() {
    return numOfCasualLeaves;
  }

  public void setNumOfCasualLeaves(int numOfCasualLeaves) {
    this.numOfCasualLeaves = numOfCasualLeaves;
  }

  public int getNumOfSickLeaves() {
    return numOfSickLeaves;
  }

  public void setNumOfSickLeaves(int numOfSickLeaves) {
    this.numOfSickLeaves = numOfSickLeaves;
  }

  public Long getLeaveDetailId() {
    return leaveDetailId;
  }

  public void setLeaveDetailId(Long leaveDetailId) {
    this.leaveDetailId = leaveDetailId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public int getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(int createdBy) {
    this.createdBy = createdBy;
  }

  public Date getUpdatedOn() {
    return updatedOn;
  }

  public void setUpdatedOn(Date updatedOn) {
    this.updatedOn = updatedOn;
  }

  public int getUpdated_by() {
    return updated_by;
  }

  public void setUpdated_by(int updated_by) {
    this.updated_by = updated_by;
  }
}
