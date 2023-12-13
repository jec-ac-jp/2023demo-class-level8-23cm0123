package com.classroom.assignment.controller;

import java.util.ArrayList;
import java.util.List;
import com.classroom.assignment.model.request.CommentForm;
import com.classroom.assignment.model.request.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/step4")
public class Step4Controller {

  @GetMapping
  public String index(CommentForm comment, Model model) {
    List<Student> studentList = new ArrayList<Student>();

    // 課題 level2 step4
    // 所属学科を追加してください。
    studentList.add(new Student("321A0001", "山田 太郎", "プログラミング専攻"));
    studentList.add(new Student("321A0002", "田中 一郎", "ロボット・Iot専攻"));
    studentList.add(new Student("321A0003", "佐藤 次郎", "クラウド専攻"));

    model.addAttribute("studentList", studentList);

    return "step4/index";
  }
}
