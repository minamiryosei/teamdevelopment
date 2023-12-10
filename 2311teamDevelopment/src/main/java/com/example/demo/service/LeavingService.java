package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.LeavingRequest;
import com.example.demo.entity.LeavingEntity;
import com.example.demo.repository.LeavingRepository;


@Service
@Transactional(rollbackFor = Exception.class)
public class LeavingService {
	@Autowired
	private LeavingRepository leavingRepository;

//退勤新規登録
public void create(LeavingRequest leavingRequest) {
	LeavingEntity attendance = new LeavingEntity();
	attendance.setUserId(leavingRequest.getUserId());
	attendance.setStatus(leavingRequest.getStatus());
	attendance.setLervingDate(leavingRequest.getLeavingDate());
	attendance.setLeavingTime(leavingRequest.getLeavingTime());
	attendance.setBreakTime(leavingRequest.getBreakTime());	
	attendance.setBreakTimes(leavingRequest.getBreakTimes());	
	

	leavingRepository.save(attendance);
}
}

