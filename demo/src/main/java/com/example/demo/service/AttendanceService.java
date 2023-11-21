package com.example.demo.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AttendanceRequest;
import com.example.demo.entity.AttendanceEntity;
import com.example.demo.repository.AttendanceRepository;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    // 勤怠情報の一覧を取得するメソッド
    public List<AttendanceEntity> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    // 勤怠情報をIDで取得するメソッド
    public Optional<AttendanceEntity> getAttendanceById(Integer id) {
        return attendanceRepository.findById(id);
    }

    // 勤怠情報を追加するメソッド
    public AttendanceEntity addAttendance(AttendanceRequest request) {
        AttendanceEntity newAttendance = new AttendanceEntity();
        // リクエストからエンティティにデータをコピーする処理をここに追加する
        return attendanceRepository.save(newAttendance);
    }

    // 勤怠情報を修正するメソッド
    public AttendanceEntity updateAttendance(Integer id, AttendanceRequest request) {
        Optional<AttendanceEntity> existingAttendance = attendanceRepository.findById(id);
        if (existingAttendance.isPresent()) {
            AttendanceEntity attendance = existingAttendance.get();
            // リクエストからエンティティにデータをコピーし、更新処理をここに追加する
            return attendanceRepository.save(attendance);
        } else {
            return null; // IDに対応する勤怠情報が存在しない場合の処理
        }
    }

    // 勤怠情報を削除するメソッド
    public void deleteAttendance(Integer id) {
        attendanceRepository.deleteById(id);
    }

}