package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.LeavingRequest;



@Controller
public class LeavingController {
	/**
	   * ユーザー情報 Service
	   */
	@Autowired
//	private LeavingService leavingService;
	  /**
	   出勤登録画面表示
	   */
	  @GetMapping("/attendance/{@attendance_id}")
		public String displayList(Model model) {
			model.addAttribute("attendanceRequest", new LeavingRequest());
			return "attendance";
	  }
			
		//出勤登録
	@PostMapping("/user/create")
	public String create(@Validated @ModelAttribute LeavingRequest attendanceRequest, BindingResult result,
			Model model) {
		//入力判定
		if (result.hasErrors()) {
			// 入力チェックエラー
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			//エラー判定後の画面遷移
			model.addAttribute("validationError", errorList);
			model.addAttribute("attendanceRequest", attendanceRequest);
			return "attendance";
		}
		// 出勤情報の登録
//		leavingService.create(attendanceRequest);
		return "redirect:/user/attendance_list";
	}	
	    




}
