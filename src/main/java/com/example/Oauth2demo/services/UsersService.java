package com.example.Oauth2demo.services;

import com.example.Oauth2demo.models.UsersHelper;
import com.example.Oauth2demo.models.UsersPojo;
import com.example.Oauth2demo.repositories.UsersDBQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements UserDetailsService {

    @Autowired
    UsersDBQuery usersDBQuery;

    @Override
    public UsersHelper loadUserByUsername(final String username) throws UsernameNotFoundException {
        UsersPojo usersPojo = null;
        try {
            usersPojo = usersDBQuery.getUserDetails(username);
            UsersHelper userDetail = new UsersHelper(usersPojo);
            return userDetail;
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
    }

}