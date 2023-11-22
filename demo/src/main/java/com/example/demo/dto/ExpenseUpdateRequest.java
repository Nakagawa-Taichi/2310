package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ユーザー情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class ExpenseUpdateRequest extends UserRequest implements Serializable {

  @NotNull
  private Long id;
  
  @NotNull(message = "ユーザーIDを入力してください")
  private Long userId;
  
  @NotEmpty(message = "申請日を入力してください")
  private String applicationDate;

  private String category;

  @NotNull(message = "経費を入力してください")
  private Integer amount;

  private String description;
}