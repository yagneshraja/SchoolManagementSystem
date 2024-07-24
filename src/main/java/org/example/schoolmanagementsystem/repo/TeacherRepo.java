package org.example.schoolmanagementsystem.repo;

import org.example.schoolmanagementsystem.entities.Teacher;
import org.example.schoolmanagementsystem.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepo extends UserRepository {

    List<User> findAll();
}
