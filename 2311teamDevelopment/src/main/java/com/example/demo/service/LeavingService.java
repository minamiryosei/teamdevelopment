package com.example.demo.service;

import java.time.Duration;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LeavingRequest;
import com.example.demo.entity.LeavingEntity;
import com.example.demo.repository.LeavingRepository;

@Service

public class LeavingService {

	@Autowired
	private LeavingRepository leavingRepository;

	public LeavingEntity getAttendance_id(Integer attendance_id) {
		return leavingRepository.getOne(attendance_id);

	}

	//退勤新規登録
	public void create(LeavingRequest leavingRequest) {
		LeavingEntity attendance = new LeavingEntity();
		attendance.setUserId(leavingRequest.getUserId());
		attendance.setStatus(leavingRequest.getStatus());
		attendance.setBreakTime(leavingRequest.getBreakTime());
		attendance.setLeavingDate(leavingRequest.getLeavingDate());
		attendance.setLeavingTime(leavingRequest.getLeavingTime());
		attendance.setBreakTimes(leavingRequest.getBreakTimes());
		attendance.setComments(leavingRequest.getComments());
		attendance.setAttendanceId(leavingRequest.getAttendanceId());
		attendance.setStartTime(leavingRequest.getStartTime());


		// 退勤から退勤計算　変数に時間を格納
		LocalTime startTime =leavingRequest.getStartTime();
		LocalTime endTime = leavingRequest.getLeavingTime();
		// 時間の差分を計算
		Duration duration = Duration.between(startTime, endTime);

		// DurationをLocalTimeに変換
		LocalTime timeDifference = LocalTime.MIDNIGHT.plus(duration);
		// 結果を表示

		attendance.setWorkTime(timeDifference);
		
		leavingRepository.save(attendance);
	}
}
