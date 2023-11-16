package com.example.demo.dto;


import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 経費情報 リクエストデータ
 */
@Data
public class ExpenseRequest implements Serializable {
	
  /**
  * ユーザーID
  */
  @NotNull(message = "ユーザーIDを入力してください")
  private int user_id;
  
  /**
   * 日付
   */
  @NotNull(message = "日付を選択してください")
  private String applicationDate;
  
  /**
   * 経費項目
   */
  @NotNull(message = "項目を選択してください")
  private String expenseCategory ;
  
  /**
   * 経費金額
   */
  @Digits(integer = 9, fraction = 0, message = "経費金額は9桁以内の数字で入力してください")
  private Integer amount;
  
  /**
   * 備考
   */
  @Size(max = 50, message = "備考は50文字以下で入力してください")
  private String description;


}
