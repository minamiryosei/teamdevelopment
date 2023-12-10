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
public class AttendanceEntity {
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
	 * 出勤日
	 */
	@Column(name = "start_date")
	private LocalDate startDate;

	/**
	 * 出勤時間
	 */
	@Column(name = "start_time")
	private LocalTime startTime;

}
	


