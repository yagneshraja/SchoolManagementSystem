package org.example.schoolmanagementsystem.repo;

import jakarta.transaction.Transactional;
import org.example.schoolmanagementsystem.entities.Student;
import org.example.schoolmanagementsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface StudentRepo extends UserRepository{
}
