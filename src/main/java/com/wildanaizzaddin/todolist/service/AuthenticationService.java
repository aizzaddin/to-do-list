package com.wildanaizzaddin.todolist.service;

import com.wildanaizzaddin.todolist.dto.AuthRequest;
import com.wildanaizzaddin.todolist.dto.AuthResponse;
import com.wildanaizzaddin.todolist.dto.RegisterRequest;

public interface AuthenticationService {
    AuthResponse register(RegisterRequest request);
    AuthResponse authenticate(AuthRequest request);
}
