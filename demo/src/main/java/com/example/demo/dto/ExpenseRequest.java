package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

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
	private Integer user_id;

	/**
	 * 日付
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "日付を選択してください")
	private LocalDate applicationDate;

	/**
	 * 経費項目
	 */
	@NotNull(message = "項目を選択してください")
	private String expenseCategory ;

	/**
	 * 経費金額
	 */
	@NotNull(message = "金額を入力してください")
	private Integer amount;

	/**
	 * 備考
	 */
	private String description;


}
