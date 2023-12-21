package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data 
public class LeavingRequest implements Serializable{

	/**
	 * ユーザー情報 リクエストデータ
	 */
	/**
	 * UserId
	 */
	private Integer userId;
	/**
	 * ステータス
	 */
	private String status;

	// 退勤日
	@NotNull(message = "日付は必須です")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate leavingDate;

	//出勤時間
	private LocalTime startTime;

	/**
	 * 退勤時間
	 */
	@NotNull( message = "退勤時間を入力してください")

	private LocalTime leavingTime;

	/**
	 * 退勤時間1
	 */
	@NotNull( message = "休憩開始時間を入力してください")
	private LocalTime  breakTime;

	/**
	 * 退勤時間2
	 */
	@NotNull( message = "休憩終了時間を入力してください")
	private LocalTime breakTimes;

	/**
	 *備考
	 */
	@Size(max = 100)
	private String comments;

	//  稼働時間
	private LocalTime  workTime;

	/**
	 * 勤怠ID
	 */
	private Integer attendanceId;
}
