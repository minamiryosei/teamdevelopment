
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

import com.example.demo.dto.AttendanceRequest;
import com.example.demo.dto.AttendanceUpdateRequest;
import com.example.demo.entity.AttendanceEntity;
import com.example.demo.service.AttendanceService;

	/**
	 * ユーザー情報 Controller
	 */
	@Controller
	public class AttendanceListController {
	  /**
	   * ユーザー情報 Service
	   */
	  //2行追加
		@Autowired
		private AttendanceService attendanceService;
	  /**
	   * ユーザー情報一覧画面を表示
	   * @param  model Model
	   * @return  ユーザー情報一覧画面のHTML
	   */
	  @RequestMapping(value = "/templates/attendanceList")
		public String displayList(Model model) {

	    List<AttendanceEntity> list = attendanceService.searchAll();
	    model.addAttribute("userlist",list);
	    return "user/list";
	  }
		/**
		   * ユーザー編集画面を表示
		   * @param  id 表示するユーザーID
		   * @param  model Model
		   * @return  ユーザー編集画面
		   */
		  @GetMapping("/user/{id}/attendanceList")
		  public String displayEdit(@PathVariable  Long id, Model model) {
			AttendanceEntity attendance = AttendanceService.findById(id);
			AttendanceUpdateRequest attendanceUpdateRequest = new AttendanceUpdateRequest();
		 //実装5行
			attendanceUpdateRequest.setId(attendance.getId());
			attendanceUpdateRequest.setName(attendance.getName());
			attendanceUpdateRequest.setPhone(attendance.getPhone());
			attendanceUpdateRequest.setAddress(attendance.getAddress());
		    model.addAttribute("userUpdateRequest", attendanceUpdateRequest);
		    return "user/edit";
		  }
		  /**
		   * ユーザー更新
		   * @param  userRequest リクエストデータ
		   * @param  model Model
		   * @return  ユーザー情報詳細画面
		   */
		  @RequestMapping("/user/update")
		  public String update(@Validated  @ModelAttribute  AttendanceUpdateRequest attendanceUpdateRequest, BindingResult result, Model model) {
		    if (result.hasErrors()) {
		      List<String> errorList = new ArrayList<String>();
		      for (ObjectError error : result.getAllErrors()) {
		        errorList.add(error.getDefaultMessage());
		      }
		      model.addAttribute("validationError", errorList);
		      return "user/edit";
		    }
		    // ユーザー情報の更新)
		    attendanceService.update(attendanceUpdateRequest);
		    return String.format("redirect:/user/%d", attendanceUpdateRequest.getId());
		  }
	}
}
