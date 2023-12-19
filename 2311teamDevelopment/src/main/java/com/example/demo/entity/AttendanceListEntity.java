
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
@Data
@Entity
@Table(name = "attendance_table" , schema = "public" )
public class AttendanceListEntity  {

	/**
	 * 勤怠ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attendance_id")
	private Long attendance_id;
	/**
	 * UserId
	 */
	@Column(name = "user_id")
	private Long user_id;
	/**
	 * ステータス
	 */
	@Column(name = "status")
	private String status;
	/**
	 * 出勤日
	 */
	@Column(name ="start_date")
	private LocalDate start_date;
	/**
	 * 出勤時間
	 */
	@Column(name = "start_time")
	private LocalTime start_time;
	/**
	 * 退勤日
	 */
	@Column(name = "leaving_date")
	private LocalDate leaving_date;
	/**
	 * 退勤時間
	 */
	@Column(name = "leaving_time")
	private LocalTime leaving_time;
	/**
	 * 稼働時間
	 */
	@Column(name = "working_time")
	private LocalTime working_time;
	/**
	 * 休憩時間１
	 */
	@Column(name = "break_time1")
	private LocalTime break_time1;
	/**
	 * 休憩時間２
	 */
	@Column(name = "break_time2")
	private LocalTime break_time2;
	/**
	 * 修正理由
	 */
	@Column(name = "edit_reason")
	private String edit_reason;
	/**
	 * 備考
	 */
	@Column(name = "comments")
	private String comments;
}
