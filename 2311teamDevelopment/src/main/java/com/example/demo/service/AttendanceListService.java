package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.AttendanceListUpdateRequest;
import com.example.demo.entity.AttendanceListEntity;
import com.example.demo.repository.AttendanceListRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AttendanceListService {
	/**
	 * ユーザー情報 Repository
	 */
	//2行追加
	@Autowired
	private AttendanceListRepository attendanceRepository;
	/**
	 * ユーザー情報 全検索
	 * @return  検索結果
	 */
	public List<AttendanceListEntity> searchAll() {
		return attendanceRepository.findAll();
	}
	/**
	 * ユーザー情報 主キー検索
	 * @return  検索結果
	 */
	public AttendanceListEntity findById(Long attendance_id) {
		return attendanceRepository.findById(attendance_id).get();
	}
	/**
	 * ユーザー情報 更新
	 * @param  user ユーザー情報
	 */
	public void update(AttendanceListUpdateRequest attendanceUpdateRequest) {
		AttendanceListEntity attendance = findById(attendanceUpdateRequest.getAttendance_id());
//		attendance.setUser_id(attendanceUpdateRequest.getUser_id());
//		attendance.setStatus(attendanceUpdateRequest.getStatus());
//		attendance.setStart_date(attendanceUpdateRequest.getStart_date());
//		attendance.setStart_time(attendanceUpdateRequest.getStart_time());
//		attendance.setLeaving_date(attendanceUpdateRequest.getLeaving_date());
//		attendance.setLeaving_time(attendanceUpdateRequest.getLeaving_time());
//		attendance.setWorking_time(attendanceUpdateRequest.getWorking_time());
//		attendance.setWorking_time(attendanceUpdateRequest.getWorking_time());
//		attendance.setComments(attendanceUpdateRequest.getComments());
	    attendanceRepository.save(attendance);
	}
}
