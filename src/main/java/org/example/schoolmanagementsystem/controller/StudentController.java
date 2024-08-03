package org.example.schoolmanagementsystem.controller;
import java.util.List;

import org.example.schoolmanagementsystem.entities.Attendance;
import org.example.schoolmanagementsystem.entities.Student;
import org.example.schoolmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@RestController
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    StudentService studentService;
    
    
    
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> findByStudentId(@RequestParam Long studentId){
       Student s = this.studentService.findByStudentId(studentId);
       return new ResponseEntity<>(s,HttpStatus.OK);
    }
    
   
    @GetMapping("/attendance/{studentId}")
    public ResponseEntity<List<Attendance>> fetchAllAttendance(@RequestParam Long studentId)
    {
        List<Attendance> l = this.studentService.listAttendanceByStudentId(studentId);

        return new ResponseEntity<>(l,HttpStatus.OK);
    }
    

    @GetMapping("/")
    public ResponseEntity<List<Student>> fetchAllStudents(){
        return new ResponseEntity<>(this.studentService.fetchAllStudents(),HttpStatus.OK);
    }
}
