package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mypageController {
	
	
  @GetMapping("/mypage")
	public String displayList(Model model) {
	   return "mypage";
	   
	}
}