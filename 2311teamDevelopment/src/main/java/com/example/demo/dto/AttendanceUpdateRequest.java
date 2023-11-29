package com.example.demo.dto;

@Data
@EqualsAndHashCode(callSuper=false)
public class AttendanceUpdateRequest extends AttendanceRequest implements Serializable {

  /**
   * ユーザーID
   */
  @NotNull
  private Integer id;