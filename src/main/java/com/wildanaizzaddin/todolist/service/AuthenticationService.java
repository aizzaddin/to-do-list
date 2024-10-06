package com.wildanaizzaddin.todolist.service;

import com.wildanaizzaddin.todolist.dto.AuthenticationDto;
import com.wildanaizzaddin.todolist.dto.RegisterDto;

public interface AuthenticationService {
    String register(RegisterDto request);
    String authenticate(AuthenticationDto request);
}
