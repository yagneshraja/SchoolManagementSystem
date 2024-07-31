package org.example.schoolmanagementsystem.service;

import java.util.List;

import org.example.schoolmanagementsystem.entities.Attendance;
import org.example.schoolmanagementsystem.entities.Student;
import org.example.schoolmanagementsystem.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentServiceImpl implements StudentService {
    
    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<Student> fetchAllStudents() {
        // TODO Auto-generated method stub
        List<Student> ls = this.studentRepo.findAll();
        return ls;
        
    }

    @Override
    public List<Attendance> listAttendanceByStudentId(Long studentId) {
        // TODO Auto-generated method stub
        List<Attendance> ls = this.studentRepo.findAttendanceByStudentId(studentId);
        return ls;
    }

    @Override
    public Student findByStudentId(Long studentId) {
        // TODO Auto-generated method stub
        Student s;
        s = this.studentRepo.findById(studentId);
        return s;
    }
    
}
