package com.classroom.assignment.service;

import java.util.ArrayList;
import java.util.List;
import com.classroom.assignment.repository.CommentDao;
import org.springframework.stereotype.Service;
import com.classroom.assignment.entity.Comment;

@Service
public class CommentServiceImpl implements CommentService {

  private final CommentDao dao;

  public CommentServiceImpl(CommentDao dao) {
    this.dao = dao;
  }

  @Override
  public void save(Comment Comment) {
    dao.insertComment(Comment);
  }

  @Override
  public List<Comment> getAll() {
    List<Comment> list = dao.getAll();
    return list;
  }

  @Override
  public List<Comment> getCommentSerchByname(String name) {
    List<Comment> list = new ArrayList<Comment>();;
    if (name.isEmpty()) {
      list = dao.getAll();
    } else {
      list = dao.getCommentSerchByname(name);
    }
    return list;
  }

  @Override
  public void deleteComment(int id) {
    dao.deleteComment(id);
  }
}
