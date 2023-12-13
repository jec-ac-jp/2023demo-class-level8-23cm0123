package com.classroom.assignment.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.classroom.assignment.entity.Comment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;

@Repository
public class CommentDaoImpl implements CommentDao {

  private final JdbcTemplate jdbcTemplate;

  public CommentDaoImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void insertComment(Comment comment) {
    jdbcTemplate.update("INSERT INTO comment(name, mail, content, created) VALUES(?, ?, ?, ?)",
        comment.getName(), comment.getMail(), comment.getContent(), comment.getCreated());
  }

  @Override
  public List<Comment> getAll() {

    String sql = "SELECT id, name, mail, content, created FROM comment";
    List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
    List<Comment> list = new ArrayList<Comment>();
    for (Map<String, Object> result : resultList) {
      Comment comment = new Comment();
      comment.setId((int) result.get("id"));
      comment.setName((String) result.get("name"));
      comment.setMail((String) result.get("mail"));
      comment.setContent((String) result.get("content"));
      comment.setCreated(((Timestamp) result.get("created")).toLocalDateTime());
      list.add(comment);
    }

    return list;
  }

  @Override
  public List<Comment> getCommentSerchByname(String name) {

    String sql = "SELECT id, name, mail, content, created FROM comment WHERE name = ?";
    List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql, name);
    List<Comment> list = new ArrayList<Comment>();
    for (Map<String, Object> result : resultList) {
      Comment comment = new Comment();
      comment.setId((int) result.get("id"));
      comment.setName((String) result.get("name"));
      comment.setMail((String) result.get("mail"));
      comment.setContent((String) result.get("content"));
      comment.setCreated(((Timestamp) result.get("created")).toLocalDateTime());
      list.add(comment);
    }

    return list;
  }

  @Override
  public void deleteComment(int id) {
    // STEP-8 削除処理のSQLを追加しましょう。
    // 削除も「jdbcTemplate.update」を使ってください。

  }
}
