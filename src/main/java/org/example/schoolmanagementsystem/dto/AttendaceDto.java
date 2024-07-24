package org.example.schoolmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendaceDto {
    private Date markingDate;
    private Long studentId;
    private Boolean status;
    private String reason;
}
