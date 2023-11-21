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
	private Integer attendance_id;
	//2行追加
	
	/**
	 * UseraID
	 */
	@Column(name = "user_id")
	private Integer user_id;

	/**
	 * ステータス
	 */
	@Column(name = "atatus")
	private String status;

	/**
	 * 出勤日
	 */
	@Column(name = "state_date")
	private LocalDate createDate;

	/**
	 * 出勤時間
	 */
	@Column(name = "state_time")
	private LocalTime createTime;

}
	


