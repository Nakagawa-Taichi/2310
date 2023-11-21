package com.example.attendance.repository;

	import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.attendance.entity.UserEntity;

	/**
	 * ユーザー情報 Repository
	 */
	@Repository
	public interface UserRepository extends JpaRepository<UserEntity, Long> {}
