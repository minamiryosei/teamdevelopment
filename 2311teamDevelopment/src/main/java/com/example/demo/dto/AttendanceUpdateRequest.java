package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class AttendanceUpdateRequest extends AttendanceRequest implements Serializable {

  /**
   * ユーザーID
   */
  @NotNull
  private Integer id;
}