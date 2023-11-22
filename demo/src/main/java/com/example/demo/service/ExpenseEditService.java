package com.example.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ExpenseUpdateRequest;
import com.example.demo.entity.ExpenseEntity;
import com.example.demo.repository.ExpenseRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class ExpenseEditService {
	
    @Autowired
    private ExpenseRepository expenseRepository;
	
	  /**
	   * 経費情報 主キー検索
	   * @return 検索結果
	   */
	  public ExpenseEntity findById(Long id) {
	    return expenseRepository.findById(id).get();
	  }
	
	  /**
	   * 経費情報 更新
	   * @param expense 経費情報
	   */
	  public void update(ExpenseUpdateRequest expenseUpdateRequest) {
		  ExpenseEntity expense = findById(expenseUpdateRequest.getId());
		    expense.setExpenseCategory(expenseUpdateRequest.getCategory());
		    expense.setAmount(expenseUpdateRequest.getAmount());
		    // StringからDateへの変換処理
		    SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
          try {
				Date date = sdFormat.parse(expenseUpdateRequest.getApplicationDate());
				expense.setApplicationDate(date);
			} catch (ParseException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
          
		    expense.setDescription(expenseUpdateRequest.getDescription());
		    expense.setApplicationDate(new Date());
		    expenseRepository.save(expense);
		}
	  
	  /**
	   * ユーザー情報 物理削除
	   * @param id ユーザーID
	   */
	  public void delete(Long id) {
	    ExpenseEntity expense = findById(id);
	    expenseRepository.delete(expense);
	  }
}