package org.example.schoolmanagementsystem.repo;

import jakarta.transaction.Transactional;
import org.example.schoolmanagementsystem.entities.Student;
import org.example.schoolmanagementsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.example.schoolmanagementsystem.entities.Attendance;

@Transactional
@Repository
public interface StudentRepo extends JpaRepository{

    List<Attendance> findAttendanceByStudentId(Long studentId);

    Student findById(Long studentId);
}
