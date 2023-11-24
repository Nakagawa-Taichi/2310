package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.AttendanceEntity;
import com.example.demo.service.AttendanceListService;

@Controller
public class AttendanceListcontroller {

	@Autowired
    private AttendanceListService attendanceListService;

    @GetMapping(value = "/attendance/AttendanceList")
    public String displayList(Model model) {
    	System.out.println(1);
        List<AttendanceEntity> attendanceList = attendanceListService.searchAll();
        model.addAttribute("attendanceList", attendanceList);
        return "/attendance/AttendanceList";
    }
}