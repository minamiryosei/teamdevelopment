package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.LeavingRequest;
import com.example.demo.entity.LeavingEntity;


@Service
@Transactional(rollbackFor = Exception.class)
public class LervingService {
	@Autowired
//	private LeavingRepository leavingRepository;

//出勤新規登録
public void create(LeavingRequest leavingRequest) {
	LeavingEntity attendance = new LeavingEntity();
//	attendance.setUserId(leavingRequest.getuser_id());
//	attendance.setStatus(leavingRequest.getstatus());
//	attendance.setLeavingDate(leavingRequest.getleaving_date());
//	attendance.setLeavingTime(leavingRequest.getleaving_Time());
//	attendance.setBreakTime(leavingRequest.gebreak_time());	
//	attendance.setBreakTimes(leavingRequest.gebreak_times());	

//	leavingRepository.save(attendance);
}
}

