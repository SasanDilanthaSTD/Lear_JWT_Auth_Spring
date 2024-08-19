package com.example.login_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.login_test.model.Users;

public interface UserRepo extends JpaRepository<Users,Integer>{
    Users findByUsername(String username);
}