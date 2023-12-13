package com.classroom.assignment.controller.api;

import static org.assertj.core.api.Assertions.assertThat;
import com.classroom.assignment.controller.Step8Controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
@AutoConfigureMockMvc
public class Step8ControllerTests {

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private Step8Controller controller;
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Test
  void contextLoads() {
    // given
    // when
    // then
    assertThat(controller).isNotNull();
  }

  @Test
  public void commentDeletingFunctionCheck() throws Exception {
    // given
    // when
    // then

    // 実行
    // 削除対象のコメントが存在していることを確認する。
    this.mockMvc.perform(get("/step8"))
        .andExpect(content().string(containsString("田中")));

    // コメントを一件削除する。
    this.mockMvc.perform(post("/step8/delete").param("deleteId", "1"))
        .andExpect(status().is(302));

    // コメントが削除され、コメント件数が3件⇒1件になっていることを確認する。
    assertEquals(2, JdbcTestUtils.countRowsInTable(jdbcTemplate, "comment"));
  }

}
