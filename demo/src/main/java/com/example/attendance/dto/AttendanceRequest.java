package com.example.attendance.dto;

public class AttendanceRequest {
    private Integer userId;
    private String status;
    private String attendanceDate;
    private String attendanceTime;
    private String leavingDate;
    private String leavingTime;
    private String remarks;

    // GetterとSetterは省略

    @Override
    public String toString() {
        return "AttendanceRequest{" +
                "userId=" + userId +
                ", status='" + status + '\'' +
                ", attendanceDate='" + attendanceDate + '\'' +
                ", attendanceTime='" + attendanceTime + '\'' +
                ", leavingDate='" + leavingDate + '\'' +
                ", leavingTime='" + leavingTime + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}