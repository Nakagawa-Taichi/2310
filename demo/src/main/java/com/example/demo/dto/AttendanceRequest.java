package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class AttendanceRequest implements Serializable {

    @NotNull(message = "ユーザーIDを入力してください")
    private Integer user_id;
    
	@NotNull(message = "ステータスを選択してください")
    private String status;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@NotNull(message = "日付を選択してください")
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
