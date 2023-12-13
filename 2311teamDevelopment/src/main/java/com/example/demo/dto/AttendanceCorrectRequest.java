package com.example.demo.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.validation.constraints.NotNull;
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
	@NotNull(message = "ユーザーIDを入力してください")
	private Long user_id;
	/**
	 * ステータス
	 */ 
	@NotNull(message = "ステータスを選択してください")
	private String status;
	/**
	 * 出勤日
	 */ 
	@NotNull(message = "出勤日を入力してください")
	private Date start_date;
	/**
	 * 出勤時間
	 */
	@NotNull(message = "出勤時間を入力してください")
	private Time start_time;
	/**
	 * 退勤日
	 */
	@NotNull(message = "退勤日を入力してください")
	private Date leaving_date;
	/**
	 * 退勤時間
	 */ 
	@NotNull(message = "退勤時間を入力してください")
	private Time leaving_time;
	/**
	 * 稼働時間
	 */ 
	@NotNull(message = "稼働時間を入力してください")
	private Time working_time;
	/**
	 * 休憩時間１
	 */ 
	@NotNull(message = "休憩時間１を入力してください")
	private Time break_time1;
	/**
	 * 休憩時間２
	 */ 
	@NotNull(message = "休憩時間２を入力してください")
	private Time break_time2;
	/*
	 * 修正理由
	 */
	@Size(max = 100, message = "備考は100文字以内で入力してください")
	private String edit_reason;
	/**
	 *　備考
	 */ 
	@Size(max = 100, message = "備考は100文字以内で入力してください")
	private String comments;
}