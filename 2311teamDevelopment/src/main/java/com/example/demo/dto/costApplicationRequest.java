package com.example.demo.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class costApplicationRequest implements Serializable {
	
	
	  /**
	   * User_id
	   */
	 @NotNull(message = "UserIDを入力してください")
	  private Integer user_id;
	  /**
	   * 申請日
	   */
	 @NotEmpty(message = "申請日を選択してください")
	  private String application_day;
	  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	  /**
	   * 項目
	   */
	  @NotEmpty(message = "項目を選択してください")
	  private String category;
	  /**
	   * 金額
	   */
	  @NotNull(message = "金額を入力してください")
	  private Integer cost;
	  /**
	   * 備考
	   */
	  @Size(max = 100, message = "備考は100文字以内で入力してください")
	  private String comments;
	  
	  
	}