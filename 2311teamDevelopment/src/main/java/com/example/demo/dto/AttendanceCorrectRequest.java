package com.example.demo.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.validation.constraints.Size;

import lombok.Data;
/**
 * 勤怠情報 リクエストデータ
 */
@Data
public class AttendanceCorrectRequest implements Serializable {
	/**
	 * ユーザーID
	 */ 
	private Long user_id;
	/**
	 * ステータス
	 */ 
	private String status;
	/**
	 * 出勤日
	 */ 
	private Date start_date;
	/**
	 * 出勤時間
	 */
	private Time start_time;
	/**
	 * 退勤日
	 */
	private Date leaving_date;
	/**
	 * 退勤時間
	 */ 
	private Time leaving_time;
	/**
	 * 稼働時間
	 */ 
	private Time working_time;
	/**
	 * 休憩時間１
	 */ 
	private Time break_time1;
	/**
	 * 休憩時間２
	 */ 
	private Time break_time2;
	/**
	 *　備考
	 */ 
	@Size(max = 100, message = "備考は100文字以内で入力してください")
	private String comments;
}