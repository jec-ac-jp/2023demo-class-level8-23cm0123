package com.classroom.assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/step2")
public class Step2Controller {

  @GetMapping()
  public String index(Model model) {
    return "step2/index";
  }

  // 例
  @GetMapping("/morning")
  // nameというパラメータ名で値を指定し、Getパラメータを必須にしない為に「name = "name", required = false」と指定する。
  public String morning(@RequestParam(name = "name", required = false) String name, Model model) {
    model.addAttribute("greeting", name + "さん、おはようございます!");
    return "step2/greeting";
  }

  // 課題 level1 step2
  @GetMapping("/evening")
  public String evening(@RequestParam(name = "name", required = false) String name, Model model) {
    // 「/step2/evening?name=○○」をURLの最後に指定した時に「○○さん、こんばんは!」と返すよう処理を追加してください。
    // ↓↓↓↓ここに処理を追加しましょう。↓↓↓↓
    model.addAttribute("greeting", name + "さん、こんばんは!");
    // ↑↑↑↑ここに処理を追加しましょう。↑↑↑↑
    return "step2/greeting";
  }
}
