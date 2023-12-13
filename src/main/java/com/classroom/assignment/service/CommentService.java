package com.classroom.assignment.service;

import com.classroom.assignment.entity.Comment;
import java.util.List;

public interface CommentService {
  void save(Comment Comment);

  List<Comment> getAll();

  List<Comment> getCommentSerchByname(String name);

  void deleteComment(int id);
}
