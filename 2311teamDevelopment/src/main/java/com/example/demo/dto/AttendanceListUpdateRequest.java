
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
public class AttendanceListUpdateRequest extends AttendanceListRequest implements Serializable {

  /**
   * ユーザーID
   */
  @NotNull
  private Long id;
}