//package com.example.demo.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.ObjectError;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.example.demo.dto.LeavingRequest;
//import com.example.demo.entity.LeavingEntity;
//import com.example.demo.service.LeavingService;
//
//
//
//@Controller
//public class LeavingController {
//	/**
//	 * ユーザー情報 Service
//	 */
//	@Autowired
//	private LeavingService leavingService;
//
//	@GetMapping("/leaving/{attendance_id}")
//	public String displayAdd(@PathVariable Integer attendance_id, Model model) {
//
//		LeavingEntity leavingRequest = leavingService.getAttendance_id(attendance_id);
//		model.addAttribute("request", leavingRequest);
//		return "leaving";
//	}
//
//	//退勤登録
//	@PostMapping("/leaving/add")
//	public String create(@Validated @ModelAttribute LeavingRequest leavingRequest, BindingResult result,
//			Model model) {
//		//入力判定
//		if (result.hasErrors()) {
//			// 入力チェックエラー
//			List<String> errorList = new ArrayList<String>();
//			for (ObjectError error : result.getAllErrors()) {
//				errorList.add(error.getDefaultMessage());
//			}
//			//エラー判定後の画面遷移
//			model.addAttribute("validationError", errorList);
//			return "leaving";
//		}
//		// 退勤情報の登録
//		leavingService.create(leavingRequest);
//		return "leaving";
//	}
//
//
//
//
//
//}
