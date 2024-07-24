package org.example.schoolmanagementsystem.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classroom_id;
    private Year year;
    private String section;
    private Boolean status;
    private String remarks;
    private Long teacher_id;
}
