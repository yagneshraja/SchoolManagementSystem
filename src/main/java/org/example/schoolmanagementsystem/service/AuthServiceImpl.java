package org.example.schoolmanagementsystem.service;


import lombok.AllArgsConstructor;
import org.example.schoolmanagementsystem.dto.LoginDto;
import org.example.schoolmanagementsystem.dto.UserDto;
import org.example.schoolmanagementsystem.entities.User;
import org.example.schoolmanagementsystem.repo.UserRepository;
import org.example.schoolmanagementsystem.security.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService{
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsernameOrEmail(),
                        loginDto.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);


        String token = jwtTokenProvider.generateToken(authentication);


        return token;
    }

    @Override
    public User createUser(UserDto userDto) {
        User newUser = new User();
        newUser.setUsername(userDto.getUsername());
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        newUser.setName(userDto.getName());



        return userRepository.save(newUser);
    }
}
