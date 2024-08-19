package com.example.login_test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.login_test.dto.UserLog;
import com.example.login_test.model.Users;
import com.example.login_test.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDataTestService {
    private final UserRepo repo;
    private final JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public List<Users> getUsers() {
        return repo.findAll();
    }


    public Users toUser(Users request) {
        request.setPssword(encoder.encode(request.getPssword()));
        return repo.save(request);
    }


    public String verfyUser(UserLog request) {
        String token = null;
        Authentication authentication =  authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                        )
        );
        if (authentication.isAuthenticated()) {
            token = jwtService.genarateToken(request.username());
            System.out.println(token);
    
            if (token == null) {
                return "Fail";
            } 
        }

        return token;

        //return authentication.isAuthenticated() ? jwtService.genarateToken(request.username()) : "Fail";
    }
    
}
