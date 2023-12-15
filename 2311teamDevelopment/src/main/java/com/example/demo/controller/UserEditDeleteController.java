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
	 * ユーザー情報一覧画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@GetMapping("UserEditDelete")
	public String displayList(Model model) {
		model.addAttribute("userEditDeleteRequest", new UserEditDeleteRequest());
		return "UserEditDelete";
	}

	/**
	 * ユーザー新規登録画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@GetMapping("UserRegistration")
	public String displayAdd(Model model) {
		return "myPage";
	}

	/**
	 * ユーザー情報詳細画面を表示
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@GetMapping("/template/{user_id}")
	public String displayView(@PathVariable Integer id, Model model) {
		@SuppressWarnings("unused")
		UserRegistrationEntity userRegistrationEntity = userEditDeleteService.findById(id);
		model.addAttribute("UserEditDelete");
		return "UserEditDelete";
	}

	/**
	 * ユーザー編集画面を表示
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー編集画面
	 */
	@GetMapping("/UserEditDelete/{id}")
	public String displayEdit(@PathVariable Integer id, Model model) {
		UserRegistrationEntity userRegistrationEntity = userEditDeleteService.findById(id);
		UserEditDeleteRequest userEditDeleteRequest = new UserEditDeleteRequest();
		userEditDeleteRequest.setId(userRegistrationEntity.getUser_id());
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
	@PostMapping("/UserEditDelete/update")
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
		return String.format("redirect:/UserEditDelete/%d", userEditDeleteRequest.getId());
	}

	/**
	 * ユーザー情報削除
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@GetMapping("/UserDelete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		// ユーザー情報の削除
		userEditDeleteService.delete(id);
		return "myPage";
	}

}