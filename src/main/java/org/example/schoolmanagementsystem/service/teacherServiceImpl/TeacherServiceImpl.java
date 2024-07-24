package org.example.schoolmanagementsystem.service.teacherServiceImpl;

//import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.schoolmanagementsystem.dto.AttendaceDto;
import org.example.schoolmanagementsystem.entities.Attendance;
import org.example.schoolmanagementsystem.entities.Role;
import org.example.schoolmanagementsystem.entities.Teacher;
//import org.example.schoolmanagementsystem.entities.User;
import org.example.schoolmanagementsystem.entities.User;
import org.example.schoolmanagementsystem.repo.AttendanceRepository;
import org.example.schoolmanagementsystem.repo.RoleRepository;
import org.example.schoolmanagementsystem.repo.TeacherRepo;
import org.example.schoolmanagementsystem.repo.UserRepository;
import org.example.schoolmanagementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
//import java.util.Optional;


@Service
//@AllArgsConstructor
@NoArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AttendanceRepository attendanceRepository;




    @Override
    public Teacher createTeacher(Teacher teacher) {

        // get role for a teacher
        Role role = roleRepository.findByName("ROLE_TEACHER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);

//        create a new teacher with details given add extra validation if needed
        Teacher newTeacher = new Teacher();
        newTeacher.setName(teacher.getName());
        newTeacher.setEmail(teacher.getEmail());
        newTeacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
        newTeacher.setUsername(teacher.getUsername());
        newTeacher.setMobile(teacher.getMobile());
        newTeacher.setDob(teacher.getDob());
        newTeacher.setRoles(roles);
        teacherRepo.save(newTeacher);


        return newTeacher;
    }

    @Override
    public List<User> getAllTeachers() {

        List<User> userList = teacherRepo.findAll();

        List<User> teachers = new ArrayList<>();
        for (User user : userList) {
            if (user.getRoles().contains(roleRepository.findByName("ROLE_TEACHER"))) {
                teachers.add(user);
            }
        }
        return teachers;
    }

    @Override
    public String markAttendance(AttendaceDto attendaceDto) {
        Attendance attendance = new Attendance();
        attendance.setDate(attendaceDto.getMarkingDate());
        attendance.setStatus(true);
        attendance.setStudentId(attendaceDto.getStudentId());
        attendance.setReason("Present");

        attendanceRepository.save(attendance);

        return "Attendance Marked";
    }


}
