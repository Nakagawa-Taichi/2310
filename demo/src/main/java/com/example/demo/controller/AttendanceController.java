//package com.example.demo.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.ObjectError;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.example.demo.dto.AttendanceRequest;
//import com.example.demo.dto.AttendanceUpdateRequest;
//import com.example.demo.entity.AttendanceEntity;
//import com.example.demo.service.AttendanceService;
//
///**
// * 出勤報告 Controller
// */
//@Controller
//public class AttendanceController {
//
//	@Autowired
//	private AttendanceService attendanceService;
//
//	/**
//	 * 出勤情報一覧画面を表示
//	 *
//	 * @param model Model
//	 * @return 出勤情報一覧画面
//	 */
//	@GetMapping(value = "/user/Attendance")
//	public String displayList(Model model) {
//		List<AttendanceEntity> attendances = attendanceService.searchAll();
//		model.addAttribute("attendances", attendances);
//		return "user/list";
//	}
//
//	/**
//	 * 出勤情報新規登録画面を表示
//	 *
//	 * @param model Model
//	 * @return ユーザー情報一覧画面
//	 */
//	@GetMapping("/user/start")
//	public String displayAdd(Model model) {
//		model.addAttribute("attendanceRequest", new AttendanceRequest());
//		return "user/start";
//	}
//
//	/**
//	 * 出勤新規登録をデータベースへ登録
//	 *
//	 * @param attendanceRequest リクエストデータ
//	 * @param result            BindingResult
//	 * @param model             Model
//	 * @return ユーザー情報一覧画面
//	 */
//	@PostMapping("/attendance/create")
//	public String create(@ModelAttribute @Validated AttendanceRequest attendanceRequest, BindingResult result,
//			Model model) {
//		model.addAttribute("attendanceRequest", new AttendanceRequest());
//		if (result.hasErrors()) {
//			// 入力チェックエラーの場合
//			List<String> errorList = new ArrayList<>();
//			for (ObjectError error : result.getAllErrors()) {
//				errorList.add(error.getDefaultMessage());
//			}
//			model.addAttribute("validationError", errorList);
//			return "user/start";
//		}
//
//		// 出勤情報の登録
//		attendanceService.create(attendanceRequest);
//		return "redirect:/user/start";
//	}
//
//	/**
//	 * 退勤情報新規登録画面を表示
//	 *
//	 * @param model Model
//	 * @return 退勤情報一覧画面
//	 */
//	@GetMapping("/user/end/{attendance_id}")
//	public String displayEnd(@PathVariable Integer attendance_id, Model model) {
//
//		AttendanceEntity attendances = attendanceService.findById(attendance_id);
//		AttendanceUpdateRequest attendanceUpdateRequest = new AttendanceUpdateRequest();
//		attendanceUpdateRequest.setAttendanceId(attendances.getAttendance_id());
//		attendanceUpdateRequest.setUserId(attendances.getUser_id());
//		attendanceUpdateRequest.setAttendanceDate(attendances.getAttendance_date());
//		attendanceUpdateRequest.setStart_time(attendances.getStart_time());
//
//
//
//		model.addAttribute("attendanceUpdateRequest", attendanceUpdateRequest);
//		return "user/end";
//	}
//
//	// 勤怠登録情報更新
//	@PostMapping("/user/update")
//	public String update(@ModelAttribute @Valid AttendanceUpdateRequest attendanceUpdateRequest, BindingResult result, Model model) {
//		if (result.hasErrors()) {
//			List<String> errorList = new ArrayList<>();
//			for (ObjectError error : result.getAllErrors()) {
//				errorList.add(error.getDefaultMessage());
//			}
//			model.addAttribute("validationError", errorList);
//			return "user/end";
//		}
//
//		// 勤怠登録情報の更新
//		attendanceService.update(attendanceUpdateRequest);
//		return "/user/list"; // リダイレクト先を修正
//	}
//}