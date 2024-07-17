package org.example.schoolmanagementsystem.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.example.schoolmanagementsystem.entities.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NonNull
    private String name;
    @NonNull
    private String username;

    @NonNull
    private String email;

    @NonNull
    private String password;

    public User toUser() {
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }
}
