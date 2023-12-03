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
@Table(name = "attendance" , schema = "public" )
public class LeavingEntity {
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
	 * 退勤日
	 */
	@Column(name = "leaving_date")
	private LocalDate LervingDate;

	/**
	 * 退勤時間
	 */
	@Column(name = "leaving_time")
	private LocalTime LeavingTime;
	
	/**
	 * 休憩時間1
	 */
	@Column(name = "break_time")
	private LocalTime BreakTime;

	/**
	 * 休憩時間2
	 */
	@Column(name = "break_times")
	private LocalTime BreakTimes;

}
