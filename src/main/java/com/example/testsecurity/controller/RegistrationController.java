package com.example.testsecurity.controller;

import com.example.testsecurity.entity.UserEntity;

import com.example.testsecurity.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class RegistrationController {

    UserService userService;
    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("userEntity",new UserEntity());
        return "registration";
    }
    @PostMapping("/registration")
    public String registration(@ModelAttribute("userEntity") @Validated UserEntity userEntity, Model model){
    userService.saveUser(userEntity);
    return "redirect:/login";
    }
}
