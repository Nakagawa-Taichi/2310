package com.example.attendance.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "attend", schema = "public")
public class AttendanceEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long user_id;
	
	@Column(name= "name")
	private String name;
	
	@Column(name = "kana")
	private String kana;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "attendance_date")
	private Date attendance_date;
	
	@Column(name = "start_time")
	private Time start_time;
	
	@Column(name = "leaving_date")
	private Date leaving_date;
	
	@Column(name = "end_time")
	private Time end_time;
	
	@Column(name = "working_hours")
	private Time working_hours;
	
	@Column(name = "break_time")
	private Time break_time;
}