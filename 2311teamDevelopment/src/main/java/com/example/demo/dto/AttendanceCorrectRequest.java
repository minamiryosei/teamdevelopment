package com.example.demo.dto;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import lombok.Data;
/**
 * 勤怠情報 リクエストデータ
 */
@Data
public class AttendanceCorrectRequest implements Serializable {
	  
	 private Long user_id;
	  
	  private String status;
	  private Date start_date;
	  private Time start_time;
	  private Date leaving_date;
	  private Time leaving_time;
	  private Time working_time;
	  private Time break_time1;
	  private Time break_time2;
	  private String comments;
}