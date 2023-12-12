package com.example.demo.service;

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
	 * @return  検索結果
	 */
	public AttendanceListEntity findById(Long attendance_id) {
		return attendanceRepository.findById(attendance_id).get();
	}
	/**
	 * 勤怠情報 更新
	 * @param  user ユーザー情報
	 */
	public void update(AttendanceCorrectUpdateRequest attendanceUpdateRequest) {
		AttendanceListEntity attendance = findById(attendanceUpdateRequest.getAttendance_id());
		attendance.setUser_id(attendanceUpdateRequest.getUser_id());
		attendance.setStatus(attendanceUpdateRequest.getStatus());
		attendance.setStart_date(attendanceUpdateRequest.getStart_date());
		attendance.setStart_time(attendanceUpdateRequest.getStart_time());
		attendance.setLeaving_date(attendanceUpdateRequest.getLeaving_date());
		attendance.setLeaving_time(attendanceUpdateRequest.getLeaving_time());
		attendance.setWorking_time(attendanceUpdateRequest.getWorking_time());
		attendance.setBreak_time1(attendanceUpdateRequest.getBreak_time1());
		attendance.setBreak_time2(attendanceUpdateRequest.getBreak_time2());
		attendance.setEdit_reason(attendanceUpdateRequest.getEdit_reason());
		attendance.setComments(attendanceUpdateRequest.getComments());
		attendanceRepository.save(attendance);
	}
}