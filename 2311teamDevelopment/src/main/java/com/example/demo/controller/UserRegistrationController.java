package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.entity.UserRegistrationEntity;
import com.example.demo.service.UserRegistrationService;

@Controller
public class UserRegistrationController<UserEditDeleteRequest> {
 @Autowired
 UserRegistrationService userRegistrationService;

 @GetMapping(value = "/user/list")
 public String displaylist(Model model) {
  List<UserRegistrationEntity> userlist = userRegistrationService.searchAll();
  model.addAttribute("userlist", userlist);
  return "user/list";
 }

 @GetMapping(value = "/user/add")
 public String displayAdd(Model model) {
	 return "user/add";
 }

// @GetMapping("/user/{id}")
//public String displayView(@PathVariable Long id, Model model) {
	// UserRegistrationEntity userRegistrationEntity = userRegistrationService.findByld(id);
	// model.addAttribute("userData", userRegistrationEntity);
	// return "user/view";
// }

 //@RequestMapping(value = "/user/update", method = RequestMethod.POST)
 //public String update(@Validated @ModelAttribute//
		// UserEditDeleteRequest userEditDeleteRequest, BindingResult result, Model model) {
	 //if(result.hasErrors()) {
		// List<String> errorList = new ArrayList<String>();
	 // for(ObjectError error : result.getAllErrors()) {
		 // errorList.add(error.getDefaultMessage());
	//  }
	//  model.addAttribute("validationError", errorList);
	//  return "user/edit";//
	// }

	// userRegistrationService.update(userEditDeleteRequest);//
	// return String format("redirect:/user/%d",
	//userEditDeleteRequest.getId());//
 //}

}