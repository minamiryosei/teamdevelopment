
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.AttendanceListEntity;
import com.example.demo.service.AttendanceListService;

	/**
	 * 勤怠一覧 Controller
	 */
	@Controller
	public class AttendanceListController {
	  /**
	   * 勤怠情報 Service
	   */
		@Autowired
		private AttendanceListService attendanceService;
	  /**
	   * 勤怠情報一覧画面を表示
	   * @param  model Model
	   * @return  ユーザー情報一覧画面のHTML
	   */
		@RequestMapping(value = "/templates/attendanceList")
		public String displayList(Model model) {
	    List<AttendanceListEntity> list = attendanceService.searchAll();
	    model.addAttribute("List",list);
	    return "templates/attendanceList";
	  }
}
