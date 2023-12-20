package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

import com.example.demo.dto.AttendanceCorrectUpdateRequest;
import com.example.demo.entity.AttendanceListEntity;
import com.example.demo.service.AttendanceCorrectService;
	/**
	 * 勤怠修正 Controller
	 */
	@Controller
public class AttendanceCorrectController {
		/**
		 * 勤怠情報 Service
		 */
		@Autowired
		private AttendanceCorrectService attendanceService;
		/**
		   * 勤怠編集画面を表示
		   * @param  id 表示する勤怠ID
		   * @param  model Model
		   * @return  勤怠修正画面
		   */
		  @GetMapping("/{attendance_id}/edit")
		  public String displayEdit(@PathVariable  Long attendance_id, Model model) {
			AttendanceListEntity attendance = attendanceService.findById(attendance_id);
			AttendanceCorrectUpdateRequest attendanceCorrectUpdateRequest = new AttendanceCorrectUpdateRequest();
			attendanceCorrectUpdateRequest.setAttendance_id(attendance.getAttendance_id());
			attendanceCorrectUpdateRequest.setUser_id(attendance.getUser_id());
			attendanceCorrectUpdateRequest.setStatus(attendance.getStatus());
			attendanceCorrectUpdateRequest.setStart_date(parseDate(attendance.getStart_date()));
			attendanceCorrectUpdateRequest.setStart_time(parseTime(attendance.getStart_time()));
			attendanceCorrectUpdateRequest.setLeaving_date(parseDate(attendance.getLeaving_date()));
			attendanceCorrectUpdateRequest.setLeaving_time(parseTime(attendance.getLeaving_time()));
			attendanceCorrectUpdateRequest.setWorking_time(parseTime(attendance.getWorking_time()));
			attendanceCorrectUpdateRequest.setBreak_time1(parseTime(attendance.getBreak_time1()));
			attendanceCorrectUpdateRequest.setBreak_time2(parseTime(attendance.getBreak_time2()));
			attendanceCorrectUpdateRequest.setEdit_reason(attendance.getEdit_reason());
			attendanceCorrectUpdateRequest.setComments(attendance.getComments());
		    model.addAttribute("attendanceCorrectUpdateRequest", attendanceCorrectUpdateRequest);
		    return "attendanceCorrect";
		  }
		  /**
		   * 勤怠修正
		   * @param  userRequest リクエストデータ
		   * @param  model Model
		   * @return  勤怠情報修正画面
		   */
		  @PostMapping(value = "/update")
		  public String update(@Validated  @ModelAttribute  AttendanceCorrectUpdateRequest attendanceCorrectUpdateRequest, BindingResult result, Model model) {
		    if (result.hasErrors()) {
		      List<String> errorList = new ArrayList<String>();
		      for (ObjectError error : result.getAllErrors()) {
		        errorList.add(error.getDefaultMessage());
		      }
		      model.addAttribute("validationError", errorList);
		      return "attendanceCorrect";
		    }
		    // 勤怠情報の修正
		    attendanceService.update(attendanceCorrectUpdateRequest);
		    return String.format("redirect:/attendanceList", attendanceCorrectUpdateRequest.getAttendance_id());
		  }
		  
		  public String parseDate(LocalDate localDate) {
			  String stringDate = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			  return stringDate;
			  }
		  public String parseTime(LocalTime localTime) {
			  String stringTime = localTime.format(DateTimeFormatter.ofPattern("HH:mm"));
			  return stringTime;
			  }
}