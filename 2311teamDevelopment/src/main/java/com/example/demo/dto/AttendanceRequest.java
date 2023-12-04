package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
  @Pattern(regexp = "^[0-9]{4}/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])$", message = "日付を入力してください")
  private LocalDate startDate;
  
  /**
   * 出勤時間
   */
  @Pattern(regexp = "^([01][0-9]|2[0-3]):[0-5][0-9]$", message = "出勤時間を入力してください")
  private LocalTime StartTime;
  
}