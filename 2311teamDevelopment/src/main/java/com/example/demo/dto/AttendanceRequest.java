package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
  @NotNull(message = "UserIdを入力してください")
  private Integer userId;
  /**
   * ステータス
   */
//  @NotNull(message = "ステータスを選択してください")
  private String status;
 
// 出勤日
  @NotEmpty(message = "日付は必須です")
//  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private String startDate;
  
  /**
   * 出勤時間
   */
  @NotEmpty( message = "出勤時間を入力してください")
//  @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
  private String startTime;
  /**
   *備考
   */
  @Size(max = 100)
  private String comments;

}
  