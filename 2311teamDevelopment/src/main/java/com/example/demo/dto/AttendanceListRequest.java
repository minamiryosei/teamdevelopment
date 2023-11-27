
package com.example.demo.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class AttendanceListRequest implements Serializable {
  /**
   * 名前
   */
  @NotEmpty(message = "名前を入力してください")
  @Size(max = 1, message = "")

 private Long user_id;
  /**
   * 住所
   */
  @Size(max = 255, message = "")
  private String status;
  /**
   * 電話番号
   */
  @Pattern(regexp = "0\\d{1,4}-\\d{1,4}-\\d{4}", message = "")
  private String start_date;
  private Time start_time;
  private Date leaving_date;
  private Time leaving_time;
  private Time working_time;
  private Time break_time1;
  private Time break_time2;
  private String comments;
}
