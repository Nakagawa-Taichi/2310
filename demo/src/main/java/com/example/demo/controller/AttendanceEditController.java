package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.AttendanceUpdateRequest;
import com.example.demo.entity.AttendanceEntity;
import com.example.demo.service.AttendanceEditService;

@Controller
public class AttendanceEditController {

	@Autowired
	private AttendanceEditService attendanceEditService;
	// 勤怠修正フォームの表示
	/**
     * 勤怠情報詳細画面を表示
     * @param id 表示するユーザーID
     * @param model Model
     * @return 経費情報詳細画面
     */

//    @GetMapping("/attend/{id}")
//    public String displayView(@PathVariable Integer id, Model model) {
//        AttendanceEntity user = attendanceEditService.findById(id);
//        model.addAttribute("attendeData", user);
//        return "user/correction";
//    }

    /**
     * 勤怠編集画面を表示
     * @param id 表示する経費ID
     * @param model Model
     * @return 経費編集画面
     */

    @GetMapping("/attend/{id}/edit")
    public String displayEdit(@PathVariable Integer id, Model model) {
        AttendanceEntity user = attendanceEditService.findById(id);
        AttendanceUpdateRequest attendanceUpdateRequest = new AttendanceUpdateRequest();
        attendanceUpdateRequest.setAttendance_id(user.getAttendance_id());
        attendanceUpdateRequest.setUser_id(user.getUser_id());
        attendanceUpdateRequest.setStatus(user.getStatus());
        attendanceUpdateRequest.setAttendance_date(parseDate(user.getAttendance_date()));
        attendanceUpdateRequest.setStart_time(parseTime(user.getStart_time()));
        attendanceUpdateRequest.setLeavingDate(parseDate(user.getLeavingDate()));
        attendanceUpdateRequest.setEndTime(parseTime(user.getEndTime()));
        attendanceUpdateRequest.setWorkingHours(parseTime(user.getWorkingHours()));
        attendanceUpdateRequest.setBreakTime(parseTime(user.getBreakTime()));
        attendanceUpdateRequest.setEdit_reason(user.getEdit_reason());
        attendanceUpdateRequest.setRemarks(user.getRemarks());
        model.addAttribute("attendanceUpdateRequest", attendanceUpdateRequest);
        return "user/correction";
    }

    /**
     * 勤怠更新
     * @param expenseRequest リクエストデータ
     * @param model Model
     * @return 経費一覧画面
     */
    @RequestMapping(value = "/attend/update", method = RequestMethod.POST)
    public String update(@Validated AttendanceUpdateRequest attendanceUpdateRequest, BindingResult result, Model model) {
    	if (result.hasErrors()) {
			return "user/correction";
		}
      // ユーザー情報の更新
      attendanceEditService.update(attendanceUpdateRequest);
      return "redirect:/attendance/AttendanceList"; //パスの変更
    }

    /**
     * 勤怠情報削除
     * @param id 表示するユーザーID
     * @param model Model
     * @return 経費一覧画面
     */
    @GetMapping("/attend/{id}/delete")
    public String delete(@PathVariable Integer id, Model model) {
      // ユーザー情報の削除
      attendanceEditService.delete(id);
      return "redirect:/attendance/AttendanceList";
    }
    //LocalDate型→String型へ変換をするメソッド
    public String parseDate(LocalDate localDate) {
		  String stringDate = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		  return stringDate;
		  }

    //LocalTime型→String型へ変換をするメソッド
	  public String parseTime(LocalTime localTime) {
		  String stringTime = localTime.format(DateTimeFormatter.ofPattern("HH:mm"));
		  return stringTime;
		  }
}
