
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.AttendanceListEntity;
import com.example.demo.service.AttendanceListService;

	/**
<<<<<<< Updated upstream
	 * 勤怠一覧 Controller
=======
	 * 勤怠情報 Controller
>>>>>>> Stashed changes
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
	   * @return  勤怠情報一覧画面のHTML
	   */
		@GetMapping(value = "/templates/attendanceList")
		public String displayList(Model model) {
	    List<AttendanceListEntity> templatesattendanceList = attendanceService.searchAll();
	    model.addAttribute("templatesattendanceList",templatesattendanceList);
	    return "templates/attendanceList";
		}
}