package com.myproduct.myproduct.controller;

import com.myproduct.myproduct.entity.UserEntity;
import com.myproduct.myproduct.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public void addNewUser(@RequestBody UserEntity userEntity){
        userService.addNewUser(userEntity);
    }

    @PostMapping("/login")
    public Boolean loginUser(){

//        UserDetails userDetails = userService.loadUserByUsername(username);
//        String encryptedPassword = userDetails.getPassword();
//        String incomingEncryptedPassword = passwordEncoder.encode(password);
//        if (encryptedPassword==incomingEncryptedPassword){
            return true;
//        }
//        else {
//            return false;
//        }
    }

}
