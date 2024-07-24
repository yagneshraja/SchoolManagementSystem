package org.example.schoolmanagementsystem.service;

import org.example.schoolmanagementsystem.dto.AttendaceDto;
import org.example.schoolmanagementsystem.entities.Teacher;
import org.example.schoolmanagementsystem.entities.User;

import java.util.List;

public interface TeacherService {
    Teacher createTeacher(Teacher teacher);

    List<User> getAllTeachers();

    String markAttendance(AttendaceDto attendaceDto);
}
