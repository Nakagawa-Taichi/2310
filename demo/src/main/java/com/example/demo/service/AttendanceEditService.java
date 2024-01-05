package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.AttendanceUpdateRequest;
import com.example.demo.entity.AttendanceEntity;
import com.example.demo.repository.AttendanceRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class AttendanceEditService {

	@Autowired
	private AttendanceRepository attendanceRepository;

	/**
	  * 経費情報 主キー検索
	  * @return 検索結果
	  */
	public AttendanceEntity findById(Integer id) {
		return attendanceRepository.findById(id).get();
	}

	/**
	 * 勤怠情報 更新
	 * @param expense 勤怠情報
	 */
	public void update(AttendanceUpdateRequest attendanceUpdateRequest) {
		AttendanceEntity attendance = findById(attendanceUpdateRequest.getAttendance_id());
		attendance.setUser_id(attendanceUpdateRequest.getUser_id());
		attendance.setStatus(attendanceUpdateRequest.getStatus());
		attendance.setAttendance_date(parseLocalDate(attendanceUpdateRequest.getAttendance_date()));
		attendance.setStart_time(parseLocalTime(attendanceUpdateRequest.getStart_time()));
		attendance.setLeavingDate(parseLocalDate(attendanceUpdateRequest.getLeavingDate()));
		attendance.setEndTime(parseLocalTime(attendanceUpdateRequest.getEndTime()));
		attendance.setWorkingHours(parseLocalTime(attendanceUpdateRequest.getWorkingHours()));
		attendance.setBreakTime(parseLocalTime(attendanceUpdateRequest.getBreakTime()));
		attendance.setEdit_reason(attendanceUpdateRequest.getEdit_reason());
		attendance.setRemarks(attendanceUpdateRequest.getRemarks());
		// StringからDateへの変換処理
		//		    SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		//          try {
		//				Date date = sdFormat.parse(attendanceUpdateRequest.getAttendanceDate());
		//				attendance.setAttendance_date(date);
		//			} catch (ParseException e) {
		//				// TODO 自動生成された catch ブロック
		//				e.printStackTrace();
		//			}
		//		    attendance.setAttendance_date(new Date());
		attendanceRepository.save(attendance);
	}

	/**
	 * ユーザー情報 物理削除
	 * @param id ユーザーID
	 */
	public void delete(Integer id) {
		AttendanceEntity attendance = findById(id);
		attendanceRepository.delete(attendance);
	}

	//String→LocalDateへ変換するメソッド
	public LocalDate parseLocalDate(String localDate) {
		String date1 = localDate;
		LocalDate date2 = LocalDate.parse(date1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return date2;
	}

	//String→LocalTimeへ変換するメソッド
	public LocalTime parseLocalTime(String localTime) {
		String time1 = localTime;
		LocalTime time2 = LocalTime.parse(time1, DateTimeFormatter.ofPattern("HH:mm"));
		return time2;
	}
}
