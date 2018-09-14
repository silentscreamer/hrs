package com.example.dto;

import java.util.Date;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Message extends BaseDto {
  @Id
  private ObjectId _id;
  private String subject;
  private Long senderId;
  private Long receiverId;
  private String messageText;
  private Date sentDate;
  private boolean isRead;
  private boolean isDeleted;

  private Date createdOn;
  private int createdBy;
  private Date updatedOn;
  private int updated_by;

  public Message() {}

  public Message(ObjectId _id, String subject, Long senderId, Long receiverId, String messageText,
      Date sentDate, boolean isRead, boolean isDeleted) {
    super();
    this._id = _id;
    this.subject = subject;
    this.senderId = senderId;
    this.receiverId = receiverId;
    this.messageText = messageText;
    this.sentDate = sentDate;
    this.isRead = isRead;
    this.isDeleted = isDeleted;
  }

  public String get_id() {
    return _id.toHexString();
  }

  public void set_id(ObjectId _id) {
    this._id = _id;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public Long getSenderId() {
    return senderId;
  }

  public void setSenderId(Long senderId) {
    this.senderId = senderId;
  }

  public Long getReceiverId() {
    return receiverId;
  }

  public void setReceiverId(Long receiverId) {
    this.receiverId = receiverId;
  }

  public String getMessageText() {
    return messageText;
  }

  public void setMessageText(String messageText) {
    this.messageText = messageText;
  }

  public Date getSentDate() {
    return sentDate;
  }

  public void setSentDate(Date sentDate) {
    this.sentDate = sentDate;
  }

  public boolean isRead() {
    return isRead;
  }

  public void setRead(boolean isRead) {
    this.isRead = isRead;
  }

  public boolean isDeleted() {
    return isDeleted;
  }

  public void setDeleted(boolean isDeleted) {
    this.isDeleted = isDeleted;
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
