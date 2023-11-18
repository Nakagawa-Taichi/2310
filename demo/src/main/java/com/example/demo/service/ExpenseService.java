package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ExpenseRequest;
import com.example.demo.entity.ExpenseEntity;
import com.example.demo.repository.ExpenseRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class ExpenseService {

	/**
	 * ユーザー情報 Repository
	 */
	@Autowired
	private ExpenseRepository expenseRepository;

	/**
	 * 経費情報 全検索
	 * 
	 * @return 検索結果
	 */
	public List<ExpenseEntity> searchAll() {
		// TODO 自動生成されたメソッド・スタブ
		return expenseRepository.findAll();
	}

	/**
	 * 経費情報 新規登録
	 * 
	 * @param expense 経費情報
	 * 
	 * 
	 */
	
	
	public void update(ExpenseRequest expenseRequest) {
		ExpenseEntity expense = new ExpenseEntity();
		expense.setUserId(expenseRequest.getUser_id());
		expense.setApplicationDate(expenseRequest.getApplicationDate());
		expense.setExpenseCategory(expenseRequest.getExpenseCategory());
		expense.setAmount(expenseRequest.getAmount());
		expense.setDescription(expenseRequest.getDescription());
		expenseRepository.save(expense);

	}

}
