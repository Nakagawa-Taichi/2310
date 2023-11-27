package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.AttendanceRequest;
import com.example.demo.dto.AttendanceUpdateRequest;
import com.example.demo.entity.AttendanceEntity;
import com.example.demo.repository.AttendanceRepository;

@Service
//データベースの操作がうまくいかなかった時に、操作を「取り消す」ための指示。
//もし何かの理由でデータの追加や変更などが失敗した場合は、この指示のおかげでデータベースは元の状態に戻る
@Transactional(rollbackFor = Exception.class)
public class AttendanceService {

	//必要なツールや部品を自動的に取り出し、このクラスで使えるようにする。
	//データベースへのアクセスを助けるツールを取り出している。
    @Autowired
    private AttendanceRepository attendanceRepository;

    //データベースに保存されているすべてのユーザー情報をとってくる役割。
    //そしてその情報をリストの形で返す。
	public List<AttendanceEntity> searchAll() {
		// TODO 自動生成されたメソッド・スタブ
		return attendanceRepository.findAll();
	}
	
	//ユーザー情報　主キー検索
	public AttendanceEntity findById(Integer attendance_id) {
	      return attendanceRepository.findById(attendance_id).get();
	  }

    // 出勤報告の処理を行うメソッド
    public void create(AttendanceRequest attendanceRequest) {
        // ここでデータベースへの保存などを実装
        AttendanceEntity attendanceEntity = new AttendanceEntity();
        attendanceEntity.setUser_id(attendanceRequest.getUserId());
        attendanceEntity.setStatus(attendanceRequest.getStatus());
        attendanceEntity.setAttendance_date(attendanceRequest.getAttendanceDate());
        attendanceEntity.setStart_time(attendanceRequest.getStart_time());
        attendanceEntity.setRemarks(attendanceRequest.getRemarks());
        attendanceRepository.save(attendanceEntity);
    }

    /* 勤怠登録情報 更新
    * @param  情報更新
    */
    public void update(AttendanceUpdateRequest attendanceUpdateRequest) {
        AttendanceEntity attendance = findById(attendanceUpdateRequest.getAttendanceId());
        attendance.setUser_id(attendanceUpdateRequest.getUserId());
        attendance.setStatus(attendanceUpdateRequest.getStatus());
        attendance.setAttendance_date(attendanceUpdateRequest.getAttendanceDate());
        attendance.setLeavingDate(attendanceUpdateRequest.getLeavingDate());
        attendance.setEndTime(attendanceUpdateRequest.getEndTime());
        attendance.setWorkingHours(attendanceUpdateRequest.getBreakTime());
        attendance.setRemarks(attendanceUpdateRequest.getRemarks());
        attendanceRepository.save(attendance);
    }
}