package com.example.login_test.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.example.login_test.model.Users;
import com.example.login_test.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDataTestService {
    private final UserRepo repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public List<Users> getUsers() {
        return repo.findAll();
    }


    public Users toUser(Users request) {
        request.setPssword(encoder.encode(request.getPssword()));
        return repo.save(request);
    }
    
}
