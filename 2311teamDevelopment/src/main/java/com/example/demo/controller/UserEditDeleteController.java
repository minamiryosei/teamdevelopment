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

@Controller
public class UserEditDeleteController {

	@Autowired
	private UserEditDeleteService userEditDeleteService;

	@GetMapping("UserEditDelete")
	public String displayEdit(@PathVariable Integer id, Model model) {
		UserRegistrationEntity userRegistrationEntity = userEditDeleteService.findById(id);
		UserEditDeleteRequest userEditDeleteRequest = new UserEditDeleteRequest();
		userEditDeleteRequest.setId(userRegistrationEntity.getUser_id());
		userEditDeleteRequest.setName(userEditDeleteRequest.getName());
		userEditDeleteRequest.setKana(userEditDeleteRequest.getKana());
		userEditDeleteRequest.setEmail(userEditDeleteRequest.getEmail());
		userEditDeleteRequest.setPassword(userEditDeleteRequest.getPassword());
		return "UserEditDelete";
	}

	@PostMapping("/UserEditDelete/update")
	public String update(@Validated @ModelAttribute UserEditDeleteRequest userEditDeleteRequest, BindingResult result,  Model model) {

		if(result.hasErrors()) {
			List<String> errorList= new ArrayList<String>();
			for(ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "UserEditDelete";
		}
		userEditDeleteService.update(userEditDeleteRequest);
		return String.format("UserRegistration", userEditDeleteRequest.getId());
	}

}