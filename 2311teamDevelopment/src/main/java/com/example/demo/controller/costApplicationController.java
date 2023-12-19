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

import com.example.demo.dto.costApplicationRequest;
import com.example.demo.service.costApplicationService;

@Controller
public class costApplicationController {

	@Autowired
	private costApplicationService costApplicationService;
	 
	/**
	 * 経費申請を表示
	 * @param model Model
	 * @return 経費申請画面
	 */
	@GetMapping("/costapplication")
	public String displayAdd(Model model) {
		model.addAttribute("costApplicationRequest", new costApplicationRequest());
		return "costApplication";
	}

	/**
	 * 経費登録
	 * @param userRequest リクエストデータ
	 * @param model Model
	 * @return 経費申請画面
	 */
	@PostMapping("/costapplication/add")
	public String create(@Validated @ModelAttribute costApplicationRequest costapplicationRequest, BindingResult result, Model model) {

		if (result.hasErrors()) {
			//入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "costApplication";
		}

		// 経費の申請
		costApplicationService.create(costapplicationRequest);
		return "myPage";
	}
}