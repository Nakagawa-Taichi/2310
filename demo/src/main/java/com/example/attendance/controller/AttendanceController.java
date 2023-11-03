package com.example.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.attendance.entity.AttendanceEntity;
import com.example.attendance.service.AttendanceService;

@Controller
public class AttendanceController {

	@Autowired
    private AttendanceService AttendanceService;

    @RequestMapping("/")
    public String listUserEntity(Model model) {
    	System.out.println(1);
        List<AttendanceEntity> userlist = AttendanceService.searchAll();
        model.addAttribute("userlist", userlist);
        return "/correction/correction";
    }
    
}