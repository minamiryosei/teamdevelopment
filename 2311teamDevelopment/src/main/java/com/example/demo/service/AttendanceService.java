package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.AttendanceRequest;
import com.example.demo.entity.AttendanceEntity;
import com.example.demo.repository.AttendanceRepository;


@Service
@Transactional(rollbackFor = Exception.class)
public class AttendanceService {

	@Autowired
	private AttendanceRepository attendanceRepository;

//出勤新規登録
public void create(AttendanceRequest attendanceRequest) {
	AttendanceEntity attendance = new AttendanceEntity();
	attendance.setUserId(attendanceRequest.getUserId());
	attendance.setStatus(attendanceRequest.getStatus());
	
    // 変換する文字列
		String string1 = attendanceRequest.getStartDate();
		// Stringからjava.time.LocalDateに変換する
		LocalDate localDate = LocalDate.parse(string1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	attendance.setStartDate(localDate);
	
	// 変換する文字列
			String string2 = attendanceRequest.getStartTime();
			// Stringからjava.time.LocalDateに変換する
			LocalTime localTime = LocalTime.parse(string2, DateTimeFormatter.ofPattern("HH:mm"));
	attendance.setStartTime(localTime);

	attendanceRepository.save(attendance);
}
}





