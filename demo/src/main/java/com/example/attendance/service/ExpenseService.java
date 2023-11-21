package com.example.attendance.service;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.attendance.dto.ExpenseRequest;
import com.example.attendance.entity.ExpenseEntity;
import com.example.attendance.repository.ExpenseRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class ExpenseService {
	

	/**
	   * ユーザー情報 Repository
	   */
    @Autowired
    private ExpenseRepository expenseRepository;

    /**
     * ユーザー情報 全検索
     * @return 検索結果
     */
	public List<ExpenseEntity> searchAll() {
		// TODO 自動生成されたメソッド・スタブ
		return expenseRepository.findAll();
	}
    

	/**
	   * ユーザー情報 新規登録
	   * @param user ユーザー情報
	   */

	 public void update(ExpenseRequest expenseRequest) {
		  ExpenseEntity expense = findById(expenseRequest.getUser_id());
		  if (expense != null) {
		    expense.setExpenseCategory(expenseRequest.getexpense_category());
		    expense.setAmount(expenseRequest.getAmount());
		    expense.setDescription(expenseRequest.getDescription());
		    expense.setApplicationDate(new Date(0));
		    expenseRepository.save(expense);
		  }
		}

	private ExpenseEntity findById(Long user_id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}




	public void create(ExpenseRequest expenseRequest) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}