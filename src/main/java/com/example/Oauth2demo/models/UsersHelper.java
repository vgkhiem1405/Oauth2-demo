package com.example.Oauth2demo.models;

import org.springframework.security.core.userdetails.User;

public class UsersHelper extends User {
    public UsersHelper(UsersPojo usersPoJo) {
        super(usersPoJo.getUsername(), usersPoJo.getPassword(), usersPoJo.getListOfgrantedAuthorities());
    }
}
