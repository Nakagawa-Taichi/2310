package com.example.demo.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 経費情報 Entity
 */
@Entity
@Data
@Table(name = "expense" , schema = "public")
public class ExpenseEntity {

	/**
	 *経費ID
	 */
	@Id
	@Column(name = "expense_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * ユーザーID
	 */
	@Column(name = "user_id")
	private int userId;
	
	/**
	 *申請日
	 */
	@Column(name = "application_date")
	private Date applicationDate;

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
	private String description;

	public void setExpenseCategory(String expenseCategory) {
	    this.expenseCategory = expenseCategory;
	}

}