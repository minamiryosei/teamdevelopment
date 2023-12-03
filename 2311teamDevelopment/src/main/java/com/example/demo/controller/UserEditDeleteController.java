package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.UserEditDeleteEntity;
import com.example.demo.service.UserEditDeleteService;

@Controller
public class UserEditDeleteController {
 @Autowired
 UserEditDeleteService userEditDeleteService;

 @GetMapping
 String list(Model model) {
  List<UserEditDeleteEntity> users = userEditDeleteService.searchAll();
  model.addAttribute("users", users);
  return "list";
 }


}