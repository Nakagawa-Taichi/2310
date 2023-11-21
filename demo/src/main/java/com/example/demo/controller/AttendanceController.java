package com.example.demo.controller;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    // 出勤操作のエンドポイント
    @PostMapping("/checkIn")
    public String checkIn() {
        // 出勤処理を行うコードを追加
        return "redirect:/attendance/list"; // 処理後に一覧表示にリダイレクト
    }

    // 退勤操作のエンドポイント
    @PostMapping("/checkOut")
    public String checkOut() {
        // 退勤処理を行うコードを追加
        return "redirect:/attendance/list"; // 処理後に一覧表示にリダイレクト
    }

    // 一覧表示のエンドポイント
    @GetMapping("/list")
    public String listAttendance() {
        // 勤怠一覧を表示するコードを追加
        return "attendanceList"; // 表示するテンプレート名を返す
    }

    // 修正操作のエンドポイント
    @PostMapping("/edit")
    public String editAttendance(@RequestParam Long id) {
        // 指定されたIDの勤怠情報を修正するコードを追加
        return "redirect:/attendance/list"; // 処理後に一覧表示にリダイレクト
    }
}