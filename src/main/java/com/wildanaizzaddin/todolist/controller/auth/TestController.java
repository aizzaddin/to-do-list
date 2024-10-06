package com.wildanaizzaddin.todolist.controller.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class TestController {
    @GetMapping("/test")
    public String test(Authentication auth) {
        return auth.getName();
    }
}
