package org.example.schoolmanagementsystem.service;

import org.example.schoolmanagementsystem.dto.LoginDto;
import org.example.schoolmanagementsystem.dto.UserDto;
import org.example.schoolmanagementsystem.entities.User;

public interface AuthService {

    String login(LoginDto loginDto);

    User createUser(UserDto userDto);
}
