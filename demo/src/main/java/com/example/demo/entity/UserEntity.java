package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


/**
* ユーザー情報 Entity
*/
@Entity
@Data
@Table(name = "user" , schema = "public" )
public class UserEntity  {

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	/**
	 * 名前
	 */

	@Column(name = "name")
	private String name;

	/**
	 * カナ
	 */
	@Column(name = "kana")
	private String kana;

	/**
	 * メールアドレス
	 */
	@Column(name = "email")
	private String email;

	/**
	 * パスワード
	 */
	@Column(name = "password")
	private String password;
}






