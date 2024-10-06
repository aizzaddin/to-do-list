package com.wildanaizzaddin.todolist.service;

import com.wildanaizzaddin.todolist.dto.AuthRequest;
import com.wildanaizzaddin.todolist.dto.AuthResponse;
import com.wildanaizzaddin.todolist.dto.RegisterRequest;
import com.wildanaizzaddin.todolist.model.UserEntity;

public interface AuthenticationService {
    AuthResponse register(RegisterRequest request);
    AuthResponse authenticate(AuthRequest request);

    UserEntity getUserByEmail(String email);
}
