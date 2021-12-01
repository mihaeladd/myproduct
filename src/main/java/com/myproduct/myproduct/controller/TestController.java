package com.myproduct.myproduct.controller;

import com.myproduct.myproduct.repository.IngredientRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "the test was successful";
    }
}
