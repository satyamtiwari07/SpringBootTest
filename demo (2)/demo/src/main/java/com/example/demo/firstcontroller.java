package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class firstcontroller {

    @GetMapping("/")
    public String homepage(){
        return "This is first app in springboot";
    }
}
