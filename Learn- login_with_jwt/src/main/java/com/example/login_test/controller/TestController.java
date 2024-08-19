package com.example.login_test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.login_test.dto.UserLog;
import com.example.login_test.model.Users;
import com.example.login_test.service.UserDataTestService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final UserDataTestService service;

    @GetMapping
    public String getMethodName() {
        return "Task Working";
    }

    @GetMapping("/get-users")
    public List<Users> getUsers() {
        return service.getUsers();
    }

    @PostMapping("/reg")
    public Users regUser(@RequestBody Users request) {
        return service.toUser(request);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody UserLog request) {
        //return "Request get";
        return service.verfyUser(request);
    }
    
    
    
    
    
}
