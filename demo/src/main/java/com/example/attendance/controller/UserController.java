package com.example.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.attendance.entity.UserEntity;
import com.example.attendance.service.UserService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class UserController {

  /**
   * ユーザー情報 Service
   */
  @Autowired
  private UserService userService;

  /**
   * ユーザー情報一覧画面を表示
   * 
   * @param  model Model 
   * @return  ユーザー情報一覧画面のHTMLのパス
   */
  @GetMapping(value = "/user/list")
  public String displayList(Model model) {
    List<UserEntity> userlist = userService.searchAll(); 
    model.addAttribute("userlist", userlist);
    return "user/list";
  }
}

