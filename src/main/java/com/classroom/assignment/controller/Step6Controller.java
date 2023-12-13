package com.classroom.assignment.controller;

import com.classroom.assignment.model.request.CommentForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/step6")
public class Step6Controller {

  @GetMapping
  public String index(CommentForm commentForm, Model model) {
    return "step6/index";
  }

  @PostMapping("/comment")
  public String evening(@Validated CommentForm commentForm, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "step6/index";
    }
    model.addAttribute("name", commentForm.getName());
    model.addAttribute("content", commentForm.getContent());
    model.addAttribute("mail", commentForm.getMail());
    return "step6/confirm";
  }
}
