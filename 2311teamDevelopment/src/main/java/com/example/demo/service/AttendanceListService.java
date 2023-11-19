package com.example.demo.service;

import java.util.Date;
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
		//1行追加
		return attendanceRepository.findAll();
	}
	/**
	 * ユーザー情報 主キー検索
	 * @return  検索結果
	 */
	public AttendanceListEntity findById(Long attendance_id) {
		//実装1行
		return attendanceRepository.findById(attendance_id).get();
	}

	/**
	 * ユーザー情報 更新
	 * @param  user ユーザー情報
	 */
	public void update(AttendanceListUpdateRequest attendanceUpdateRequest) {
		//実装6行
		AttendanceListEntity user = findById(attendanceUpdateRequest.getId());
	    user.setuser_id(attendanceUpdateRequest.getuser_id());
	    user.setstatus(attendanceUpdateRequest.getstatus());
	    user.setPhone(attendanceUpdateRequest.getPhone());
	    user.setUpdateDate(new Date());
	    attendanceRepository.save(user);
	}
}
