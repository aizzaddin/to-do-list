package com.wildanaizzaddin.todolist.service.impl;

import com.wildanaizzaddin.todolist.config.JwtService;
import com.wildanaizzaddin.todolist.dto.AuthenticationDto;
import com.wildanaizzaddin.todolist.dto.RegisterDto;
import com.wildanaizzaddin.todolist.model.Role;
import com.wildanaizzaddin.todolist.model.UserEntity;
import com.wildanaizzaddin.todolist.repository.UserRepository;
import com.wildanaizzaddin.todolist.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public String register(RegisterDto request) {
        Optional<UserEntity> user = userRepository.findByEmail(request.getEmail());
        if (user.isEmpty()) {
            UserEntity newUser = userRepository.save(UserEntity
                    .builder()
                            .name(request.getName())
                            .email(request.getEmail())
                            .password(passwordEncoder.encode(request.getPassword()))
                            .role(Role.USER)
                    .build());
            return jwtService.generateToken(newUser);
        }

        throw new RuntimeException("Email already registered");
    }

    @Override
    public String authenticate(AuthenticationDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        return jwtService.generateToken(user);
    }
}
