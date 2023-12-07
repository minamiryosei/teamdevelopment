package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_cost")
public class costApplicationEntity {   

	  /**
	   * 経費ID
	   */
	  @Id
	  @Column(name = "cost_id")
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private String cost_id;
	  /**
	   * ユーザーID
	   */
	  @Column(name = "user_id")
	  private String user_id;
	  /**
	   * 申請日
	   */
	  @Column(name = "application_day")
	  private Date application_day;
	  /**
	   * 項目
	   */
	  @Column(name = "category")
	  private String category;
	  /**
	   * コスト
	   */
	  @Column(name = "cost")
	  private String cost;
	  /**
	   * 備考
	   */
	  @Column(name = "comments")
	  private String comments;
}

