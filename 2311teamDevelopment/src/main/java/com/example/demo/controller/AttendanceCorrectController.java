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

import com.example.demo.dto.AttendanceCorrectUpdateRequest;
import com.example.demo.entity.AttendanceListEntity;
import com.example.demo.service.AttendanceCorrectService;
	/**
	 * 勤怠修正 Controller
	 */
	@Controller
public class AttendanceCorrectController {
		/**
		 * ユーザー情報 Service
		 */
		@Autowired
		private AttendanceCorrectService attendanceService;
		/**
		   * ユーザー編集画面を表示
		   * @param  id 表示するユーザーID
		   * @param  model Model
		   * @return  ユーザー編集画面
		   */
		  @GetMapping("/templates/{id}/edit")
		  public String displayEdit(@PathVariable  Long attendance_id, Model model) {
			AttendanceListEntity attendance = attendanceService.findById(attendance_id);
			AttendanceCorrectUpdateRequest attendanceUpdateRequest = new AttendanceCorrectUpdateRequest();
			attendanceUpdateRequest.setAttendance_id(attendance.getAttendance_id());
			attendanceUpdateRequest.setUser_id(attendance.getUser_id());
			attendanceUpdateRequest.setStatus(attendance.getStatus());
			attendanceUpdateRequest.setStart_date(attendance.getStart_date());
			attendanceUpdateRequest.setStart_time(attendance.getStart_time());
			attendanceUpdateRequest.setLeaving_date(attendance.getLeaving_date());
			attendanceUpdateRequest.setLeaving_time(attendance.getLeaving_time());
			attendanceUpdateRequest.setWorking_time(attendance.getWorking_time());
			attendanceUpdateRequest.setBreak_time1(attendance.getBreak_time1());
			attendanceUpdateRequest.setBreak_time2(attendance.getBreak_time2());
			attendanceUpdateRequest.setComments(attendance.getComments());
		    model.addAttribute("attendanceUpdateRequest", attendanceUpdateRequest);
		    return "attendanceCorrect";
		  }
		  /**
		   * ユーザー更新
		   * @param  userRequest リクエストデータ
		   * @param  model Model
		   * @return  ユーザー情報詳細画面
		   */
		  @RequestMapping("/templates/attendanceCorrect")
		  public String update(@Validated  @ModelAttribute  AttendanceCorrectUpdateRequest attendanceUpdateRequest, BindingResult result, Model model) {
		    if (result.hasErrors()) {
		      List<String> errorList = new ArrayList<String>();
		      for (ObjectError error : result.getAllErrors()) {
		        errorList.add(error.getDefaultMessage());
		      }
		      model.addAttribute("validationError", errorList);
		      return "attendanceCorrect";
		    }
		    // ユーザー情報の更新)
		    attendanceService.update(attendanceUpdateRequest);
		    return String.format("redirect:/attendanceList/%d", attendanceUpdateRequest.getAttendance_id());
		  }
}