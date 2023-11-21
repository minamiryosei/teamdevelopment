package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.AttendanceRepository;

/**
 * ユーザー情報 Service
 */
@Service
//@Transactional(rollbackFor = Exception.class)
public class AttendanceService {
	/**
	 * ユーザー情報 Repository
	 */
	//2行追加
	@Autowired
	private AttendanceRepository attendanceRepository;

	
	}


