package com.example.demo.service;

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
		  AttendanceEntity attendance = findById(attendanceUpdateRequest.getAttendanceId());
		    attendance.setUser_id(attendanceUpdateRequest.getUserId());
		    attendance.setStatus(attendanceUpdateRequest.getStatus());
		    attendance.setAttendance_date(attendanceUpdateRequest.getAttendanceDate());
		    attendance.setStart_time(attendanceUpdateRequest.getStart_time());
		    attendance.setLeavingDate(attendanceUpdateRequest.getLeavingDate());
		    attendance.setEndTime(attendanceUpdateRequest.getEndTime());
		    attendance.setWorkingHours(attendanceUpdateRequest.getWorkingHours());
		    attendance.setBreakTime(attendanceUpdateRequest.getBreakTime());
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
}
