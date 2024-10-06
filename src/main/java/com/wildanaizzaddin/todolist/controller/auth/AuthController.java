package com.wildanaizzaddin.todolist.controller.auth;

import com.wildanaizzaddin.todolist.dto.AuthRequest;
import com.wildanaizzaddin.todolist.dto.AuthResponse;
import com.wildanaizzaddin.todolist.dto.RegisterRequest;
import com.wildanaizzaddin.todolist.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest register) {
        AuthResponse response = authenticationService.register(register);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest auth) {
        AuthResponse response = authenticationService.authenticate(auth);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
