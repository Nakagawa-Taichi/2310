package com.example.attendance.entity;


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
@Table(name = "勤怠テーブル")
public class AttendanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "No")
    private Integer no;

    @Column(name = "ユーザーID")
    private Integer userId;

    @Column(name = "ステータス")
    private String status;

    @Column(name = "出勤日")
    private Date attendanceDate;

    @Column(name = "出勤時間")
    private Time attendanceTime;

    @Column(name = "退勤日")
    private Date leavingDate;

    @Column(name = "退勤時間")
    private Time leavingTime;

    @Column(name = "稼働時間")
    private Time workingHours;

    @Column(name = "休憩時間")
    private Time breakTime;

    @Column(name = "備考")
    private String remarks;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

}