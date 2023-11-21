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
public class ExpenseUpdateRequest extends UserRequest implements Serializable {

  @NotNull
  private Long id;

  @NotNull
  private String category;

  @NotNull
  private Integer amount;

  @NotNull
  private String description;
}