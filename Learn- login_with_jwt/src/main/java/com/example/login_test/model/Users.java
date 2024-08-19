package com.example.login_test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @Id
    private Integer id;
    private String username;
    private String pssword;


    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", pssword=" + pssword + "]";
    } 
}
