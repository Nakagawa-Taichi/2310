package com.example.demo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class AttendanceRequest implements Serializable {

    @NotNull(message = "ユーザーIDを入力してください")
    private Integer userId;
    
    @NotNull(message = "ステータスを選択してください")
    private String status;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate attendanceDate;

    private LocalTime start_time;

    private LocalDate leavingDate;

    private LocalTime endTime;

    private LocalTime workingHours;

    private LocalTime breakTime;

    private String remarks;

}
