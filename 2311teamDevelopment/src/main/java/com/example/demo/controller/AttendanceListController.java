
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

import com.example.demo.dto.AttendanceListUpdateRequest;
import com.example.demo.entity.AttendanceListEntity;
import com.example.demo.service.AttendanceListService;

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
		private AttendanceListService attendanceService;
	  /**
	   * ユーザー情報一覧画面を表示
	   * @param  model Model
	   * @return  ユーザー情報一覧画面のHTML
	   */
	  @RequestMapping(value = "/templates/attendanceList")
		public String displayList(Model model) {
	    List<AttendanceListEntity> list = attendanceService.searchAll();
	    model.addAttribute("templatesattendanceList",list);
	    return "templates/attendancelist";
	  }
		/**
		   * ユーザー編集画面を表示
		   * @param  id 表示するユーザーID
		   * @param  model Model
		   * @return  ユーザー編集画面
		   */
		  @GetMapping("/templates/{id}/attendanceList")
		  public String displayEdit(@PathVariable  Long attendance_id, Model model) {
			AttendanceListEntity attendance = attendanceService.findById(attendance_id);
			AttendanceListUpdateRequest attendanceUpdateRequest = new AttendanceListUpdateRequest();
			attendanceUpdateRequest.setAttendance_id(attendance.getAttendance_id());
//			attendanceUpdateRequest.setUser_id(attendance.getUser_id());
//			attendanceUpdateRequest.setStatus(attendance.getStatus());
//			attendanceUpdateRequest.setStart_date(attendance.getStart_date());
//			attendanceUpdateRequest.setStart_time(attendance.getStart_time());
//			attendanceUpdateRequest.setLeaving_date(attendance.getLeaving_date());
//			attendanceUpdateRequest.setLeaving_time(attendance.getLeaving_time());
//			attendanceUpdateRequest.setWorking_time(attendance.getWorking_time());
//			attendanceUpdateRequest.setComments(attendance.getComments());
		    model.addAttribute("attendanceUpdateRequest", attendanceUpdateRequest);
		    return "templates/attendanceCorrect";
		  }
		  /**
		   * ユーザー更新
		   * @param  userRequest リクエストデータ
		   * @param  model Model
		   * @return  ユーザー情報詳細画面
		   */
		  @RequestMapping("/templates/attendanceCorrect")
		  public String update(@Validated  @ModelAttribute  AttendanceListUpdateRequest attendanceUpdateRequest, BindingResult result, Model model) {
		    if (result.hasErrors()) {
		      List<String> errorList = new ArrayList<String>();
		      for (ObjectError error : result.getAllErrors()) {
		        errorList.add(error.getDefaultMessage());
		      }
		      model.addAttribute("validationError", errorList);
		      return "user/attendanceCorrect";
		    }
		    // ユーザー情報の更新)
		    attendanceService.update(attendanceUpdateRequest);
		    return String.format("redirect:/attendanceList/%d", attendanceUpdateRequest.getAttendance_id());
		  }
}
