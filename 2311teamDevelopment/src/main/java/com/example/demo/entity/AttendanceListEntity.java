
package com.example.demo.entity;

import java.sql.Time;
import java.util.Date;

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
@Table(name = "attendance" , schema = "public" )
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
	private Date start_date;
	/**
	 * 出勤時間
	 */
	@Column(name = "start_time")
	private Time start_time;
	/**
	 * 退勤日
	 */
	@Column(name = "leaving_date")
	private Date leaving_date;
	/**
	 * 退勤時間
	 */
	@Column(name = "leaving_time")
	private Time leaving_time;
	/**
	 * 稼働時間
	 */
	@Column(name = "working_time")
	private Time working_time;
	/**
	 * 休憩時間１
	 */
	@Column(name = "break_time1")
	private Time break_time1;
	/**
	 * 休憩時間２
	 */
	@Column(name = "break_time2")
	private Time break_time2;
	/**
	 * 備考
	 */
	@Column(name = "comments")
	private String comments;
}
