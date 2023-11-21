package com.example.attendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendance.entity.AttendanceListEntity;
import com.example.attendance.repository.AttendanceListRepository;

@Service
public class AttendanceListService {
    @Autowired
    private AttendanceListRepository attendanceListRepository;

    public List<AttendanceListEntity> serchAll() {
        return attendanceListRepository.findAll();
    }
}