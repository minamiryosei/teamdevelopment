package com.example.demo.service;

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
	attendance.setStarteDate(attendanceRequest.getStartDate());
	attendance.setStartTime(attendanceRequest.getStartTime());

	attendanceRepository.save(attendance);
}
}
	
	


