package org.example.schoolmanagementsystem.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.example.schoolmanagementsystem.entities.Teacher;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
public class TeacherRequestDto {
    @NonNull
    private String name;
    @NonNull
    private String username;
    @NonNull
    private String email;
    @NonNull
    private String password;
    private Date dob;
    private String mobile;


    public static Teacher toTeacher(TeacherRequestDto teacherRequestDto){
        Teacher teacher = new Teacher();
        teacher.setName(teacherRequestDto.getName());
        teacher.setUsername(teacherRequestDto.getUsername());
        teacher.setEmail(teacherRequestDto.getEmail());
        teacher.setPassword(teacherRequestDto.getPassword());
        teacher.setDob(teacherRequestDto.getDob());
        teacher.setMobile(teacherRequestDto.getMobile());
        return teacher;

    }


}
