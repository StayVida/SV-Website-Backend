package com.stayvida.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stayvida.backend.dto.SignupRequest;
import com.stayvida.backend.service.UserService;
@RestController
@RequestMapping("/api/signup")
@CrossOrigin(origins = "*")
public class SignupController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> signup(@RequestBody SignupRequest request) {
        try {
            userService.registerUser(
                request.getEmail(),
                request.getUsername(),
                request.getPassword()
            );
            return ResponseEntity.ok("Signup successful");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
