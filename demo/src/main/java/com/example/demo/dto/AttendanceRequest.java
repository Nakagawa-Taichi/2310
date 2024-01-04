package com.example.demo.dto;

import java.io.Serializable;

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
    private String attendance_date;

    private String start_time;

    private String leavingDate;

    private String endTime;

    private String workingHours;

    private String breakTime;

    private String edit_reason;

    private String remarks;

}
