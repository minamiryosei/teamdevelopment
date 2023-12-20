package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.AttendanceCorrectUpdateRequest;
import com.example.demo.entity.AttendanceListEntity;
import com.example.demo.repository.AttendanceListRepository;

/**
 * 勤怠情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AttendanceCorrectService {
	/**
	 * 勤怠情報 Repository
	 */
	@Autowired
	private AttendanceListRepository attendanceRepository;

	/**
	 * 勤怠情報 主キー検索
	 * 
	 * @return 検索結果
	 */
	public AttendanceListEntity findById(Long attendance_id) {
		return attendanceRepository.findById(attendance_id).get();
	}

	/**
	 * 勤怠情報 更新
	 * 
	 * @param user ユーザー情報
	 */
	public void update(AttendanceCorrectUpdateRequest attendanceUpdateRequest) {
		AttendanceListEntity attendance = findById(attendanceUpdateRequest.getAttendance_id());
		attendance.setUser_id(attendanceUpdateRequest.getUser_id());
		attendance.setStatus(attendanceUpdateRequest.getStatus());
		attendance.setStart_date(parseLocalDate(attendanceUpdateRequest.getStart_date()));
		attendance.setStart_time(parseLocalTime(attendanceUpdateRequest.getStart_time()));
		attendance.setLeaving_date(parseLocalDate(attendanceUpdateRequest.getLeaving_date()));
		attendance.setLeaving_time(parseLocalTime(attendanceUpdateRequest.getLeaving_time()));
		attendance.setWorking_time(parseLocalTime(attendanceUpdateRequest.getWorking_time()));
		attendance.setBreak_time1(parseLocalTime(attendanceUpdateRequest.getBreak_time1()));
		attendance.setBreak_time2(parseLocalTime(attendanceUpdateRequest.getBreak_time2()));
		attendance.setEdit_reason(attendanceUpdateRequest.getEdit_reason());
		attendance.setComments(attendanceUpdateRequest.getComments());
		attendanceRepository.save(attendance);
	}

	public LocalDate parseLocalDate(String date) {
		// 変換する文字列
		String date1 = date;
		// Stringからjava.time.LocalDateに変換する
		LocalDate date2 = LocalDate.parse(date1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return date2;
	}

	public LocalTime parseLocalTime(String time) {
		// 変換する文字列
		String time1 = time;
		// Stringからjava.time.LocalDateに変換する
		LocalTime time2 = LocalTime.parse(time1, DateTimeFormatter.ofPattern("HH:mm"));
		return time2;
	}

}