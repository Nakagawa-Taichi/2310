//package com.example.demo.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.demo.dto.AttendanceRequest;
//import com.example.demo.entity.AttendanceEntity;
//import com.example.demo.repository.AttendanceRepository;
//
//@Service
////データベースの操作がうまくいかなかった時に、操作を「取り消す」ための指示。
////もし何かの理由でデータの追加や変更などが失敗した場合は、この指示のおかげでデータベースは元の状態に戻る
//@Transactional(rollbackFor = Exception.class)
//public class AttendanceService {
//
//	//必要なツールや部品を自動的に取り出し、このクラスで使えるようにする。
//	//データベースへのアクセスを助けるツールを取り出している。
//    @Autowired
//    private AttendanceRepository attendanceRepository;
//
//    //データベースに保存されているすべてのユーザー情報をとってくる役割。
//    //そしてその情報をリストの形で返す。
//	public List<AttendanceEntity> searchAll() {
//		// TODO 自動生成されたメソッド・スタブ
//		return attendanceRepository.findAll();
//	}
//	
//	//ユーザー情報　主キー検索
//	public AttendanceEntity findById(Integer attendance_id) {
//	      Optional<AttendanceEntity> userOptional = attendanceRepository.findById(attendance_id);
//	      return userOptional.orElse(null); // エンティティが存在しない場合はnullを返す。
//	  }
//
//    // 出勤報告の処理を行うメソッド
//    public void create(AttendanceRequest attendanceRequest) {
//        // ここでデータベースへの保存などを実装
//        AttendanceEntity attendanceEntity = new AttendanceEntity();
//        attendanceEntity.setUser_id(attendanceRequest.getUser_id());
//        attendanceEntity.setStatus(attendanceRequest.getStatus());
//        attendanceEntity.setAttendance_date(attendanceRequest.getAttendance_date());
//        attendanceEntity.setStart_time(attendanceRequest.getStart_time());
//        attendanceEntity.setRemarks(attendanceRequest.getRemarks());
//        attendanceRepository.save(attendanceEntity);
//    }
//
//}