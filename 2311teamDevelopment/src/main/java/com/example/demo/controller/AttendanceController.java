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

import com.example.demo.dto.AttendanceRequest;
import com.example.demo.service.AttendanceService;

/**
 * ユーザー情報 Controller
 */
@Controller
@Validated
public class AttendanceController {
	/**
	   * ユーザー情報 Service
	   */
	@Autowired
	private AttendanceService attendanceService;

		
		 @GetMapping(value = "templates/attendance{@attendance_id}")
		  public String displayAdd(Model model) {
		    model.addAttribute("userRequest", new AttendanceRequest());
		    return "attendance";
		  }
			
		//出勤登録
	@PostMapping("/create")
	public String create(@Validated @ModelAttribute AttendanceRequest attendanceRequest, BindingResult result,
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
			model.addAttribute("attendanceReque"
					+ "st", attendanceRequest);
			return "attendance";
		}
		// 出勤情報の登録
		attendanceService.create(attendanceRequest);
		return "redirect:attendance";
	}	
	    



	  }


