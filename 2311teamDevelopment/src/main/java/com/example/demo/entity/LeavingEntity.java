package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@Table(name = "attendance_table" , schema = "public" )
public class LeavingEntity {
	/**
	 * 勤怠ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attendance_id")
	private Integer attendanceId;
	//2行追加
	
	/**
	 * UserID
	 */
	@Column(name = "user_id")
	private Integer userId;

	/**
	 * ステータス
	 */
	@Column(name = "status")
	private String status;

	/**
	 * 退勤日
	 */
	@Column(name = "leaving_date")
	private LocalDate leavingDate;

	/**
	 * 退勤時間
	 */
	@Column(name = "leaving_time")
	private LocalTime leavingTime;
	
	/**
	 * 休憩時間1
	 */
	@Column(name = "break_time1")
	private LocalTime breakTime;

	/**
	 * 休憩時間2
	 */
	@Column(name = "break_time2")
	private LocalTime breakTimes;
	
	/**
	 * 備考
	 */
	@Column(name = "comments")
	private String comments;
	
	/**
	 * 稼働時間
	 */
	@Column(name = "working_time")
	private LocalTime workTime;
	


		
	}


