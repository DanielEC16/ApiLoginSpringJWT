package com.spring.security.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/method")
public class TestAuthController {

    @GetMapping("/get")
    public String helloGet(){
        return "Hello Wo - GET";
    }

    @PostMapping("/post")
    public String helloPost(){
        return "Hello World - POST";
    }

    @PutMapping("/put")
    public String helloPut(){
        return "Hello World - PUT";
    }

    @DeleteMapping("/delete")
    public String helloDelete(){
        return "Hello World - DELETE";
    }

    @PatchMapping("/patch")
    public String helloPatch(){
        return "Hello World - PATCH";
    }
}
