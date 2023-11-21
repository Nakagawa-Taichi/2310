
package com.example.demo.entity;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
 * 経費情報 Entity(データベースへ登録するためのデータを格納しておくためのクラス)
 */
@Data
@Entity
@Table(name = "expense" , schema = "public")
public class ExpenseEntity {

	/**
	 *経費ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "expense_id")
	private Integer id;

	/**
	 * ユーザーID
	 */
	@Column(name = "user_id")
	private int userId;
	/**
	 *申請日
	 */
	@Column(name = "application_date")
	private LocalDate applicationDate;

	/**
	 *経費項目
	 */
	@Column(name = "expense_category")
	private String expenseCategory;

	/**
	 * 金額
	 */
	@Column(name = "amount")
	private int amount;

	/**
	 * 備考
	 */
	@Column(name = "description")
	private String	 description;

}