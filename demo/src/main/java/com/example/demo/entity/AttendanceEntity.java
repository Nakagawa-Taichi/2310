package com.example.demo.entity;


import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "attend")
public class AttendanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Integer attendance_id; 
   
    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "status")
    private String status;

    @Column(name = "attendance_date")
    private LocalDate attendance_date;

    @Column(name = "start_time")
    private LocalTime start_time;

    @Column(name = "leaving_date")
    private LocalDate leavingDate;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "working_hours")
    private LocalTime workingHours;
    
    @Column(name = "break_time")
    private LocalTime breakTime;

    @Column(name = "remarks")
    private String remarks;
}