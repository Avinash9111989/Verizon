package com.example.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<String> users() {
        return List.of("Avinash", "John", "Priya");
    }
}
