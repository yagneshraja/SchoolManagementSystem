package org.example.schoolmanagementsystem.controller;


import lombok.AllArgsConstructor;
import org.example.schoolmanagementsystem.dto.AttendaceDto;
import org.example.schoolmanagementsystem.dto.TeacherRequestDto;
import org.example.schoolmanagementsystem.dto.TeacherResponseDto;
import org.example.schoolmanagementsystem.entities.Attendance;
import org.example.schoolmanagementsystem.entities.Teacher;
import org.example.schoolmanagementsystem.entities.User;
import org.example.schoolmanagementsystem.service.TeacherService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    private TeacherService teacherService;


    // say teacher hello
    @GetMapping
    @PreAuthorize("hasRole('TEACHER')")
    public String hello(){
        return "Hello Teacher";
    }


    @PostMapping("/createTeacher")
    @PreAuthorize("hasRole('ADMIN')")
    public Teacher createTeacher(@RequestBody TeacherRequestDto teacherRequestDto){
        Teacher teacher = teacherService.createTeacher(TeacherRequestDto.toTeacher(teacherRequestDto));
        return teacher;
    }

    @GetMapping("/getAllTeachers")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @PostMapping("/markAttendance")
    @PreAuthorize("hasRole('TEACHER')")
    public String markAttendance(@RequestBody  AttendaceDto attendaceDto){
        return teacherService.markAttendance(attendaceDto);


    }


}
