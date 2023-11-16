package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ExpenseEntity;
/**
 * ユーザー情報 Repository(データベースにデータを新規登録するためのクラス)
 */
@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {
}
