package com.classroom.assignment.controller;

import com.classroom.assignment.model.request.CommentForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.classroom.assignment.service.CommentService;
import com.classroom.assignment.entity.Comment;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/step8")
public class Step8Controller {

  private final CommentService commentService;

  public Step8Controller(CommentService commentService) {
    this.commentService = commentService;
  }

  @GetMapping()
  public String index(CommentForm commentForm, Model model) {
    List<Comment> list = commentService.getAll();
    model.addAttribute("commentList", list);

    return "step8/index";
  }

  @PostMapping()
  public String pageBack(CommentForm commentForm, Model model) {
    List<Comment> list = commentService.getAll();
    model.addAttribute("commentList", list);
    model.addAttribute("comment", commentForm);

    return "step8/index";
  }

  @PostMapping("/comment")
  public String comment(@Validated CommentForm commentForm, BindingResult result, Model model) {
    if (result.hasErrors()) {
      List<Comment> list = commentService.getAll();
      model.addAttribute("commentList", list);

      return "step8/index";
    }
    model.addAttribute("name", commentForm.getName());
    model.addAttribute("content", commentForm.getContent());
    model.addAttribute("mail", commentForm.getMail());
    return "step8/confirm";
  }

  @PostMapping("/save")
  public String save(@Validated CommentForm commentForm, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "redirect:";
    }
    Comment Comment = new Comment();
    Comment.setName(commentForm.getName());
    Comment.setMail(commentForm.getMail());
    Comment.setContent(commentForm.getContent());
    Comment.setCreated(LocalDateTime.now());

    commentService.save(Comment);

    return "redirect:";
  }

  @GetMapping("/search-name")
  public String searchName(@RequestParam(name = "searchName", required = false) String name,
      CommentForm commentForm, Model model) {
    List<Comment> list = new ArrayList<>();
    if (name.isEmpty()) {
      list = commentService.getAll();
    } else {
      list = commentService.getCommentSerchByname(name);
    }

    model.addAttribute("commentList", list);
    model.addAttribute("searchName", name);

    return "step8/index";
  }

  @PostMapping("/delete")
  public String delete(int deleteId, Model model) {
    commentService.deleteComment(deleteId);

    return "redirect:";
  }
}
