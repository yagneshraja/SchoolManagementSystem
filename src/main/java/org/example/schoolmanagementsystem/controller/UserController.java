package org.example.schoolmanagementsystem.controller;


import lombok.AllArgsConstructor;
import org.apache.catalina.UserDatabase;
import org.example.schoolmanagementsystem.dto.UserDto;
import org.example.schoolmanagementsystem.entities.User;
import org.example.schoolmanagementsystem.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final AuthService authService;


    @PostMapping("/createUser")
    public User createUser(@RequestBody UserDto userDto){
        return authService.createUser(userDto);
    }

}
