package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
public class costApplicationRequest implements Serializable {
	
	
	  /**
	   * User_id
	   */
	 @NotEmpty(message = "UserIDを入力してください")
	  private String user_id;
	  /**
	   * 申請日
	   */
	  @NotNull(message = "申請日を選択してください")
	  private Date application_day;
	  /**
	   * 項目
	   */
	  @NotEmpty(message = "項目を選択してください")
	  private String category;
	  /**
	   * 金額
	   */
	  @NotEmpty(message = "金額を入力してください")
	  private String cost;
	  /**
	   * 備考
	   */
	  @Size(max = 100, message = "備考は100文字以内で入力してください")
	  private String comments;
	  
	  
	}