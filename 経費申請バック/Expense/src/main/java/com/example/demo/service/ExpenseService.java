package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.ExpenseEntity;
import com.example.demo.repository.ExpenseRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class ExpenseService {
	
	  @Autowired
	    public ExpenseService() {
	        // サービスの初期化
	    }
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
		return null;
	}
    
    public List<ExpenseEntity> getAllExpenses() {
        return expenseRepository.findAll();
    }
	  /**
	   * ユーザー情報 新規登録
	   * @param user ユーザー情報
	   */


	public void create(ExpenseService expenseService) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
    

   
	
