package com.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UsersController {

    @GetMapping("/hola")
    public String listar(){
        return "Hola Mundo";
    }

    @GetMapping("/hola-secured")
    public String helloSecured(){
        return "Hola secured";
    }

}
