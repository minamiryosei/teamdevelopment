package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * ユーザー情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class AttendanceCorrectUpdateRequest extends AttendanceCorrectRequest implements Serializable  {
	/**
	 * 勤怠ID
	 */
	  @NotNull
	  private Long attendance_id;
}