package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.costListEntity;
import com.example.demo.service.costListService;

@Controller
public class costListController {
	
@Autowired
private costListService costlistService;

/**
 * マイページを表示
 * @param model Model
 * @return マイページ
 */
@GetMapping(value = "/myPage")
public String displayList(Model model) {
	List<costListEntity> mypage = costlistService.searchAll();
	model.addAttribute("mypage", mypage);
	return "/myPage";
}


@GetMapping("/list")
	public String displayAdd(Model model) {
    List<costListEntity> userlist = costlistService.searchAll();
	    model.addAttribute("userlist", userlist);
	    return "costList";
  }
}
