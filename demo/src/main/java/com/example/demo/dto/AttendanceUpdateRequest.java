package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AttendanceUpdateRequest implements Serializable {

	private Integer attendance_id;

	@NotNull(message = "ユーザーIDを入力してください")
	private Integer user_id;

	@NotNull(message = "ステータスを選択してください")
	private String status;

	@NotEmpty(message = "出勤日を入力してください")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String attendance_date;

	@NotEmpty(message = "出勤時間を入力してください")
	private String start_time;

	@NotEmpty(message = "退勤日を入力してください")
	private String leavingDate;

	@NotEmpty(message = "退勤時間を入力してください")
	private String endTime;

	@NotEmpty(message = "稼働時間を入力してください")
	private String workingHours;

	@NotEmpty(message = "休憩時間を入力してください")
	private String breakTime;

	@NotEmpty(message = "修正理由を入力してください")
	private String edit_reason;

	private String remarks;
}