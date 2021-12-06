package com.myproduct.myproduct.controller;

import com.myproduct.myproduct.entity.UserEntity;
import com.myproduct.myproduct.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void addNewUser(@RequestBody UserEntity userEntity){
        userService.addNewUser(userEntity);
    }

//    @GetMapping("/login")
//    public UserEntity loginUser() {
//
//    }
}
