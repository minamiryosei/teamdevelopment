package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data 
public class LeavingRequest implements Serializable{

/**
 * ユーザー情報 リクエストデータ
 */
 /**
   * UserId
   */
  @NotNull(message = "UserIdを入力してください")
//  @Size(max = 10, message = "UserIdは10桁以内で入力してください")
  private Integer userId;
  /**
   * ステータス
   */
//  @NotEmpty(message = "ステータスを選択してください")
//  @Size(max = 10, message = "ステータスを選択してください")
  private String status;
 
// 退勤日
  @NotNull(message = "日付は必須です")
//  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private String leavingDate;
  
  /**
   * 退勤時間
   */
  @NotEmpty( message = "退勤時間を入力してください")
//  @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
  private String leavingTime;
  
  /**
   * 退勤時間1
   */
  @NotEmpty( message = "休憩開始時間を入力してください")
//  @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
  private String  breakTime;
  /**
   * 退勤時間2
   */
  @NotEmpty( message = "休憩終了時間を入力してください")
//  @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
  /**
   *備考
   */
  @Size(max = 100)
  private String comments;
  
//  稼働時間
  private String  breakTimes;
  /**
   * 勤怠ID
   */
  private Integer attendanceId;
}

