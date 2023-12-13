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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.UserEditDeleteRequest;
import com.example.demo.service.UserEditDeleteService;

@Controller
public class UserEditDeleteController {
 @Autowired
 private UserEditDeleteService userEditDeleteService;


@GetMapping("UserEditDelete")
public String displayAdd(Model model) {
	model.addAttribute("userEditDeleteRequest", new UserEditDeleteRequest());
	return "UserEditDelete";
}

@RequestMapping(value="/UserEditDelete/create", method=RequestMethod.POST)
public String create(@Validated @ModelAttribute UserEditDeleteRequest userEditDeleteRequest, BindingResult result,  Model model) {

	if(result.hasErrors()) {
		List<String> errorList= new ArrayList<String>();
		for(ObjectError error : result.getAllErrors()) {
			errorList.add(error.getDefaultMessage());
		}
		model.addAttribute("validationError", errorList);
		return "UserEditDelete";
	}
	userEditDeleteService.update(userEditDeleteRequest);
	return "myPage";
}

}