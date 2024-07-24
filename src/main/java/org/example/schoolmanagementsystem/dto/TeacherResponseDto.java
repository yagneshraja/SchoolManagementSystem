package org.example.schoolmanagementsystem.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.schoolmanagementsystem.entities.Teacher;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherResponseDto {
    private String username;
    private String name;
    private String password;
    private String email;
    private String mobile;



    public static TeacherResponseDto toTeacherResponseDto(Teacher teacher) {
        TeacherResponseDto teacherResponseDto = new TeacherResponseDto();
        teacherResponseDto.setUsername(teacher.getUsername());
        teacherResponseDto.setPassword(teacher.getPassword());
        teacherResponseDto.setEmail(teacher.getEmail());
        teacherResponseDto.setMobile(teacher.getMobile());
        teacherResponseDto.setName(teacher.getName());

        return teacherResponseDto;
//        teacherResponseDto.setUsername(teacher.getUsername());






    }
}
