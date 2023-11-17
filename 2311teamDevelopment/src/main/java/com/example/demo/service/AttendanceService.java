package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.AttendanceUpdateRequest;
import com.example.demo.entity.AttendanceEntity;
import com.example.demo.repository.AttendanceRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AttendanceService {
	/**
	 * ユーザー情報 Repository
	 */
	//2行追加
	@Autowired
	private AttendanceRepository attendanceRepository;
	/**
	 * ユーザー情報 全検索
	 * @return  検索結果
	 */
	public List<AttendanceEntity> searchAll() {
		//1行追加
		return attendanceRepository.findAll();
	}
	/**
	 * ユーザー情報 主キー検索
	 * @return  検索結果
	 */
	public AttendanceEntity findById(Long id) {
		//実装1行
		return attendanceRepository.findById(id).get();
	}

	/**
	 * ユーザー情報 更新
	 * @param  user ユーザー情報
	 */
	public void update(AttendanceUpdateRequest attendanceUpdateRequest) {
		//実装6行
		AttendanceEntity user = findById(attendanceUpdateRequest.getId());
	    user.setAddress(attendanceUpdateRequest.getAddress());
	    user.setName(attendanceUpdateRequest.getName());
	    user.setPhone(attendanceUpdateRequest.getPhone());
	    user.setUpdateDate(new Date());
	    attendanceRepository.save(user);
	}
}
