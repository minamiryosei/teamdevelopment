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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserEditDeleteRequest;
import com.example.demo.entity.UserRegistrationEntity;
import com.example.demo.service.UserEditDeleteService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class UserEditDeleteController {

	/**
	 * ユーザー情報 Service
	 */
	@Autowired
	private UserEditDeleteService userEditDeleteService;


	/**
	 * ユーザー編集画面を表示
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー編集画面
	 */
	@GetMapping("/UserEdit/{user_id}")
	public String displayEdit(@PathVariable Integer user_id, Model model) {
		UserRegistrationEntity userRegistrationEntity = userEditDeleteService.findById(user_id);
		UserEditDeleteRequest userEditDeleteRequest = new UserEditDeleteRequest();
		userEditDeleteRequest.setUser_id(userRegistrationEntity.getUser_id());
		userEditDeleteRequest.setName(userRegistrationEntity.getName());
		userEditDeleteRequest.setKana(userRegistrationEntity.getKana());
		userEditDeleteRequest.setEmail(userRegistrationEntity.getEmail());
		userEditDeleteRequest.setPassword(userRegistrationEntity.getPassword());
		model.addAttribute("userEditDeleteRequest", userEditDeleteRequest);
		return "UserEditDelete";
	}

	/**
	 * ユーザー更新
	 * @param userRequest リクエストデータ
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@PostMapping("/UserEdit/update")
	public String update(@Validated @ModelAttribute UserEditDeleteRequest userEditDeleteRequest, BindingResult result, Model model) {

		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();

			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "UserEditDelete";
		}

		// ユーザー情報の更新
		userEditDeleteService.update(userEditDeleteRequest);
		return "myPage";
	}

	/**
	 * ユーザー情報削除
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@GetMapping("/UserDelete/{user_id}")
	public String delete(@PathVariable Integer user_id, Model model) {
		// ユーザー情報の削除
		userEditDeleteService.delete(user_id);
		return "myPage";
	}

}