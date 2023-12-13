package com.classroom.assignment.model.request;

import java.time.LocalDateTime;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;

public class CommentForm {

  @Size(min = 1, max = 20, message = "20文字以内で入力してください")
  private String name;

  @NotEmpty
  private String content;

  @NotEmpty(message = "メールアドレスを入力してください")
  @Email(message = "メールアドレスの形式ではありません")
  private String mail;

  private LocalDateTime created;

  private int id;

  public CommentForm() {}

  public CommentForm(String name, String content, String mail) {
    this.setId(id);
    this.setName(name);
    this.setContent(content);
    this.setMail(mail);
    this.setCreated(created);
  }

  public CommentForm(int id, String name, String content, String mail, LocalDateTime created) {
    this.setId(id);
    this.setName(name);
    this.setContent(content);
    this.setMail(mail);
    this.setCreated(created);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
