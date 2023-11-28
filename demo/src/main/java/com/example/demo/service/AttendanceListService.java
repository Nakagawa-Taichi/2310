package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AttendanceEntity;
import com.example.demo.repository.AttendanceRepository;

@Service
public class AttendanceListService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<AttendanceEntity> searchAll() {
        return attendanceRepository.findAll();
    }
}
