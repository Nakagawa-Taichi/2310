package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
    @GetMapping("/attend/{id}")
    public String displayView(@PathVariable Integer id, Model model) {
        AttendanceEntity user = attendanceEditService.findById(id);
        model.addAttribute("attendeData", user);
        return "user/correction";
    }

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
        attendanceUpdateRequest.setAttendanceId(user.getAttendance_id());
        attendanceUpdateRequest.setUserId(user.getUser_id());
        attendanceUpdateRequest.setStatus(user.getStatus());
        attendanceUpdateRequest.setAttendanceDate(user.getAttendance_date());
        attendanceUpdateRequest.setStart_time(user.getStart_time());
        attendanceUpdateRequest.setLeavingDate(user.getLeavingDate());
        attendanceUpdateRequest.setEndTime(user.getEndTime());
        attendanceUpdateRequest.setWorkingHours(user.getWorkingHours());
        attendanceUpdateRequest.setBreakTime(user.getBreakTime());
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
    public String update(@Validated @ModelAttribute AttendanceUpdateRequest attendanceUpdateRequest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<String> errorList = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
              errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
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
}
