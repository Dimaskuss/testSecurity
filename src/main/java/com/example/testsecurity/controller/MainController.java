package com.example.testsecurity.controller;

import lombok.Builder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Builder
@Controller
public class MainController {
    @GetMapping("/")
    public String main(){
    return "main";
    }@GetMapping("/login")
    public String login(){
    return "login";
    }


}
