package com.example.demo.entity;


import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
/**
 * ユーザー情報 Entity
 */
@Entity
@Data
//@Table(name = "attendance" , schema = "public" )
public class AttendanceEntity {
	/**
	 * 勤怠ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attendance_id")
	private Integer UttendanceId;
	//2行追加
	
	/**
	 * UserID
	 */
	@Column(name = "user_id")
	private String UserId;

	/**
	 * ステータス
	 */
	@Column(name = "status")
	private String Status;

	/**
	 * 出勤日
	 */
	@Column(name = "start_date")
	private LocalDate StarteDate;

	/**
	 * 出勤時間
	 */
	@Column(name = "start_time")
	private LocalTime StartTime;

}
	


