package com.example.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.attendance.entity.AttendanceListEntity;
import com.example.attendance.service.AttendanceListService;

@Controller
public class AttendanceListcontroller {

	@Autowired
    private AttendanceListService attendanceListService;

    @GetMapping(value = "/attendance/Attendance")
    public String displayList(Model model) {
    	System.out.println(1);
        List<AttendanceListEntity> attendanceList = attendanceListService.serchAll();
        model.addAttribute("attendanceList", attendanceList);
        return "/correction/Attendance";
    }
}