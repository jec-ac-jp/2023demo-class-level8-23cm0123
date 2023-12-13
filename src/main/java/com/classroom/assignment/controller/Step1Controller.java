package com.classroom.assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/step1")
public class Step1Controller {

  @GetMapping
  public String index(Model model) {
    model.addAttribute("title", "hello world");
    return "step1/index";
  }
}
