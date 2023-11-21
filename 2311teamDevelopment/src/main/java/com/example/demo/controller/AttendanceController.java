package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.AttendanceService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class AttendanceController {
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
	  @RequestMapping("/user/list")
		public String displayList(Model model) {
//		  List<AttendanceEntity> userlist = attendanceService.searchAll();
//			model.addAttribute("userlist", userlist);
			return "user/list";
	    //3行追加



	  }

}
