package com.example.hengtaimerp.controller;

import com.example.hengtaimerp.entity.User;
import com.example.hengtaimerp.utils.JwtUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {
    @GetMapping("/test")
    public String Test(@RequestBody User user){
        return JwtUtils.JwtToken(user);
    }
}
