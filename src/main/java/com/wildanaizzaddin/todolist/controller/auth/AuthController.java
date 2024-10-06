package com.wildanaizzaddin.todolist.controller.auth;

import com.wildanaizzaddin.todolist.dto.AuthenticationDto;
import com.wildanaizzaddin.todolist.dto.RegisterDto;
import com.wildanaizzaddin.todolist.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    public ResponseEntity<Map<String, String>> register(@RequestBody RegisterDto register) {
        Map<String, String> response = new HashMap<>();

        response.put("token", authenticationService.register(register));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/auth")
    public ResponseEntity<Map<String, String>> authenticate(@RequestBody AuthenticationDto auth) {
        Map<String, String> response = new HashMap<>();

        response.put("token", authenticationService.authenticate(auth));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
