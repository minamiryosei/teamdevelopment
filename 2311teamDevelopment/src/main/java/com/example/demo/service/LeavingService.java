//package com.example.demo.service;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.dto.AttendanceRequest;
//import com.example.demo.dto.LeavingRequest;
//import com.example.demo.entity.LeavingEntity;
//import com.example.demo.repository.LeavingRepository;
//
//@Service
//
//public class LeavingService {
//
//	@Autowired
//	private LeavingRepository leavingRepository;
//
//
//
//	public LeavingEntity getAttendance_id(Integer attendance_id) {
//        return leavingRepository.getOne(attendance_id);
//
//    }
//
//	//退勤新規登録
//	public void create(LeavingRequest leavingRequest) {
//		LeavingEntity attendance = new LeavingEntity();
//		attendance.setUserId(leavingRequest.getUserId());
//		attendance.setStatus(leavingRequest.getStatus());
//
//		// 変換する文字列（退勤日）
//		String leavingstring1 = leavingRequest.getLeavingDate();
//		// Stringからjava.time.LocalDateに変換する
//		LocalDate localDate = LocalDate.parse(leavingstring1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//		attendance.setLeavingDate(localDate);
//
//		// 変換する文字列（退勤時間）
//		String leavingstring2 = leavingRequest.getLeavingTime();
//		// Stringからjava.time.LocalTimeに変換する
//		LocalTime localLeavingTime = LocalTime.parse(leavingstring2, DateTimeFormatter.ofPattern("HH:mm"));
//		attendance.setLeavingTime(localLeavingTime);
//
//		// 変換する文字列（休憩開始）
//		String leavingstring3 = leavingRequest.getBreakTime();
//		// Stringからjava.time.LocalTimeに変換する
//		LocalTime localBreakTime1 = LocalTime.parse(leavingstring3, DateTimeFormatter.ofPattern("HH:mm"));
//		attendance.setBreakTime(localBreakTime1);
//
//		// 変換する文字列（休憩終了）
//		String leavingstring4 = leavingRequest.getBreakTimes();
//		// Stringからjava.time.LocalTimeに変換する
//		LocalTime localBreakTime2 = LocalTime.parse(leavingstring4, DateTimeFormatter.ofPattern("HH:mm"));
//		attendance.setBreakTimes(localBreakTime2);
//
//
//		AttendanceRequest attendanceRequest = new AttendanceRequest();
//
//		String stringStartTime = attendanceRequest.getStartTime();
//		LocalTime localStartTime = LocalTime.parse(stringStartTime, DateTimeFormatter.ofPattern("HH:mm"));
//
//		long breakTime = calculateBreakTimeInMinutes(localBreakTime1, localBreakTime2);
//
//		long workHours = calculateWorkTimeInMinutes(localStartTime, localLeavingTime);
//
//		long workTime = workHours - breakTime;
//		attendance.setWorkTime(workTime);
//
//		leavingRepository.save(attendance);
//	}
//
//
//
//		//休憩時間の計算
//	private long calculateBreakTimeInMinutes(LocalTime startTime, LocalTime endTimes) {
//		// 休憩時間の差を計算
//		long startTimeInMinutes = startTime.getHour() * 60 + startTime.getMinute();
//		long endTimesInMinutes = endTimes.getHour() * 60 + endTimes.getMinute();
//		return startTimeInMinutes - endTimesInMinutes;
//	}
//
//	private long calculateWorkTimeInMinutes(LocalTime startTime, LocalTime leavingTime) {
//		// 出勤時間と退勤時間の差を計算
//		long startTimeInMinutes = startTime.getHour() * 60 + startTime.getMinute();
//		long leavingTimeInMinutes = leavingTime.getHour() * 60 + leavingTime.getMinute();
//		return leavingTimeInMinutes - startTimeInMinutes;
//	}
//
//
//}
