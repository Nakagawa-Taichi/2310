package com.example.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.attendance.entity.ExpenseEntity;

/**
 * 経費情報 Repository
 */
@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {
}
