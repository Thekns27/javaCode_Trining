package org.example.methodsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
        return"GET TEST!";
    }
    @PostMapping
    public String test2(){
        return "POST TEST!";
    }
}
