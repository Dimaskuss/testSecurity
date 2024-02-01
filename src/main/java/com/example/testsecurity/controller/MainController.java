package com.example.testsecurity.controller;

import com.example.testsecurity.service.UserService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Builder
@Controller
@RequiredArgsConstructor
public class MainController {
    private final UserService userService;
    @GetMapping("/")
    public String main(Model model){
    model.addAttribute("users",userService.getAll());
        return "main";
    }@GetMapping("/login")
    public String login(){
    return "login";
    }


}
