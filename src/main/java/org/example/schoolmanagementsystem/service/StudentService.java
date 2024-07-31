package org.example.schoolmanagementsystem.service;
import java.util.List;
import org.example.schoolmanagementsystem.entities.Student;
import org.example.schoolmanagementsystem.entities.Attendance;
public interface StudentService{

    List<Student> fetchAllStudents();

    List<Attendance> listAttendanceByStudentId(Long studentId);

    Student findByStudentId(Long studentId);
    


}
