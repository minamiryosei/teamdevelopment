package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data 
public class AttendanceRequest implements Serializable{

/**
 * ユーザー情報 リクエストデータ
 */
 /**
   * UserId
   */
  @NotEmpty(message = "UserIdを入力してください")
  @Size(max = 10, message = "UserIdは10桁以内で入力してください")
  private String UserId;
  /**
   * ステータス
   */
  @NotEmpty(message = "ステータスを選択してください")
  @Size(max = 10, message = "ステータスを選択してください")
  private String Status;
 
// 出勤日
  @NotNull(message = "日付は必須です")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate startDate;
  
  /**
   * 出勤時間
   */
  @NotNull( message = "出勤時間を入力してください")
  @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
  private LocalTime startTime;

  /**
   * 勤怠ID
   */
  private Integer attendance_id;
}
  
