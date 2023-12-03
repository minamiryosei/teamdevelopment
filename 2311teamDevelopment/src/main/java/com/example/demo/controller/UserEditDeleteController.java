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

import com.example.demo.dto.UserEditDeleteRequest;
import com.example.demo.entity.UserEditDeleteEntity;
import com.example.demo.entity.UserRegistrationEntity;
import com.example.demo.service.UserEditDeleteService;
import com.example.demo.service.UserRegistrationService;

@Controller
public class UserEditDeleteController {
 @Autowired
 UserEditDeleteService userEditDeleteService;

 @GetMapping(value = "/user/list")
 public String displaylist(Model model) {
  List<UserEditDeleteEntity> userlist = userEditDeleteService.searchAll();
  model.addAttribute("userlist", userlist);
  return "user/list";
 }

 @GetMapping(value = "/user/add")
 public String displayAdd(Model model) {
	 return "user/add";
 }

 @GetMapping("/user/{id}")
public String displayView(@PathVariable Long id, Model model) {
	 UserEditDeleteEntity userEditDeleteEntity = userEditDeleteService.findByld(id);
	 model.addAttribute("userData", userEditDeleteEntity);
	 return "user/view";
 }

 @RequestMapping(value = "/user/update", method = RequestMethod.POST)
 public String update(@Validated @ModelAttribute
		 UserEditDeleteRequest userEditDeleteRequest, BindingResult result, Model model) {
	 if(result.hasErrors()) {
		 List<String> errorList = new ArrayList<String>();
	  for(ObjectError error : result.getAllErrors()) {
		  errorList.add(error.getDefaultMessage());
	  }
	  model.addAttribute("validationError", errorList);
	  return "user/edit";
	 }

	 userEditDeleteService.update(userEditDeleteRequest);
	 return String format("redirect:/user/%d",
	userEditDeleteRequest.getId());
 }

}}