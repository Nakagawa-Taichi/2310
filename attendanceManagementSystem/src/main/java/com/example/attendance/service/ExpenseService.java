package com.example.attendance.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.attendance.dto.ExpenseUpdateRequest;
import com.example.attendance.entity.ExpenseEntity;
import com.example.attendance.repository.ExpenseRepository;

/**
 * 経費のService
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ExpenseService {
  
  /**
   * 経費テーブルへのRepository
   */
  @Autowired
  private ExpenseRepository expenseRepository;
  
  /**
   * 経費情報 全検索
   * @return 検索結果
   */
  public List<ExpenseEntity> searchAll() {
    return expenseRepository.findAll();
  }
  
  /**
   * 経費情報 主キー検索
   * @return 検索結果
   */
  public ExpenseEntity findById(Long id) {
    return expenseRepository.findById(id).orElse(null);
  }
  
  /**
   * 経費情報 更新
   * @param expenseUpdateRequest 経費更新リクエスト
   */
  public void update(ExpenseUpdateRequest expenseUpdateRequest) {
	  ExpenseEntity expense = findById(expenseUpdateRequest.getId());
	  if (expense != null) {
	    expense.setExpenseCategory(expenseUpdateRequest.getCategory());
	    expense.setAmount(expenseUpdateRequest.getAmount());
	    expense.setDescription(expenseUpdateRequest.getDescription());
	    expense.setApplicationDate(new Date());
	    expenseRepository.save(expense);
	  }
	}
}
