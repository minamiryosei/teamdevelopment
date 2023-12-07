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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.UserRegistrationRequest;
import com.example.demo.entity.UserRegistrationEntity;
import com.example.demo.service.UserRegistrationService;

@Controller
public class UserRegistrationController {
 @Autowired
 private UserRegistrationService userRegistrationService;

@GetMapping(value="/user/list")
public String displayList(Model model) {
	List<UserRegistrationEntity> userlist = userRegistrationService.searchAll();
	model.addAttribute("userlist", userlist);
	return "user/list";
}

@GetMapping(value="/user/add")
public String displayAdd(Model model) {
	model.addAttribute("userRegistrationRequest", new UserRegistrationRequest());
	return "user/add";
}

@RequestMapping(value="/user/create", method= RequestMethod.POST)
public String create(@Validated @ModelAttribute UserRegistrationRequest userRegistrationRequest, BindingResult result,  Model model) {

	if(result.hasErrors()) {
		List<String> errorList= new ArrayList<String>();
		for(ObjectError error : result.getAllErrors()) {
			errorList.add(error.getDefaultMessage());
		}
		model.addAttribute("validationError", errorList);
		return "user/add";
	}
	userRegistrationService.create(userRegistrationRequest);
	return "redirect:/user/list";
}
@GetMapping("/user/{id}")
public String displayView(@PathVariable Long id, Model model) {
	return "user/view";
}
}