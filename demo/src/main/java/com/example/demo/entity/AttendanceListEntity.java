package com.example.demo.entity;


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
@Table(name = "勤怠テーブル", schema = "public")
public class AttendanceListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "No")
    private Integer no;

    @Column(name = "ユーザーID")
    private Integer user_id;

    @Column(name = "ステータス")
    private String status;

    @Column(name = "出勤日")
    private Date attendance_Date;

    @Column(name = "出勤時間")
    private Time start_time;

    @Column(name = "退勤日")
    private Date leaving_date;

    @Column(name = "退勤時間")
    private Time end_Time;

    @Column(name = "稼働時間")
    private Time workingHours;

    @Column(name = "休憩時間")
    private Time break_time;

    @Column(name = "備考")
    private String remarks;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }
}