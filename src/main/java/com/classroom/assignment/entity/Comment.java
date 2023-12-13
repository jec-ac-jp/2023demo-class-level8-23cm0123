package com.classroom.assignment.entity;

import java.time.LocalDateTime;

public class Comment {
  private int id;
  private String name;
  private String mail;
  private String content;
  private LocalDateTime created;

  public Comment() {}

  public Comment(int id, String name, String mail, String content, LocalDateTime created) {
    super();
    this.id = id;
    this.name = name;
    this.mail = mail;
    this.content = content;
    this.created = created;
  }


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }
}
