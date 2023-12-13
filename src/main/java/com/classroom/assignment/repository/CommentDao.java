package com.classroom.assignment.repository;

import java.util.List;
import com.classroom.assignment.entity.Comment;

public interface CommentDao {
  void insertComment(Comment comment);

  List<Comment> getAll();

  List<Comment> getCommentSerchByname(String name);

  public void deleteComment(int id);

}
