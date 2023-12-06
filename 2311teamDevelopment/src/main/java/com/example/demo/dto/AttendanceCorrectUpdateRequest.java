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
	   * ユーザーID
	   */
	  @NotNull
	  private Long attendance_id;

	public Object getAttendance_id() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}