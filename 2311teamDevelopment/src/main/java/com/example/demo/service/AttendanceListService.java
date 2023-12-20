package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
