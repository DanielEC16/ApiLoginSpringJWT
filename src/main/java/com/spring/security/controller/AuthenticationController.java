package com.spring.security.controller;

import com.spring.security.controller.dto.AuthLoginRequest;
import com.spring.security.controller.dto.AuthResponse;
import com.spring.security.service.UserDetailServicesImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserDetailServicesImpl userDetailServices;

    @PostMapping("/log-in")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthLoginRequest userRequest){
        return  new ResponseEntity<>(this.userDetailServices.loginUser(userRequest), HttpStatus.OK);
    }
}
