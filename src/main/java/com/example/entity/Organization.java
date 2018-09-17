package com.example.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.example.constants.Status;
import com.example.dto.BaseDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "organization")
@JsonIgnoreProperties(value = {"createdOn", "updatedOn"}, allowGetters = true)
public class Organization extends BaseDto {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "name")
  @NotNull
  private String name;
  @Column(name = "description")
  private String description;
  @Column(name = "organization_type")
  @NotNull
  private String organizationType;
  @Column(name = "parent_id")
  private Long parentId;
  @Column(name = "creation_mode")
  private String creationMode;
  @Column(name = "status")
  private Status status;
  @Column(name = "logo_id")
  private String logoId;
  @Column(name = "created_on", nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  private Date createdOn;
  @Column(name = "created_by")
  private Long createdBy;
  @Column(name = "updated_on", nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  private Date updatedOn;
  @Column(name = "updated_by")
  private Long updatedBy;

  public Organization() {}

  public Organization(@NotNull String name, String description, @NotNull String organizationType,
      Long parentId, String creationMode, Status status, String logoId) {
    super();
    this.name = name;
    this.description = description;
    this.organizationType = organizationType;
    this.parentId = parentId;
    this.creationMode = creationMode;
    this.status = status;
    this.logoId = logoId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getOrganizationType() {
    return organizationType;
  }

  public void setOrganizationType(String organizationType) {
    this.organizationType = organizationType;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public String getCreationMode() {
    return creationMode;
  }

  public void setCreationMode(String creationMode) {
    this.creationMode = creationMode;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public String getLogoId() {
    return logoId;
  }

  public void setLogoId(String logoId) {
    this.logoId = logoId;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public Long getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(Long createdBy) {
    this.createdBy = createdBy;
  }

  public Date getUpdatedOn() {
    return updatedOn;
  }

  public void setUpdatedOn(Date updatedOn) {
    this.updatedOn = updatedOn;
  }

  public Long getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(Long updatedBy) {
    this.updatedBy = updatedBy;
  }
}
