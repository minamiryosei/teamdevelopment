package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.UserRegistrationEntity;
import com.example.demo.service.UserRegistrationService;

@Controller
public class UserRegistrationController {
 @Autowired
 UserRegistrationService userRegistrationService;

 @GetMapping
 String list(Model model) {
  List<UserRegistrationEntity> users = userRegistrationService.searchAll();
  model.addAttribute("users", users);
  return "list";
 }


}