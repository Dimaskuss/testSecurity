package com.example.testsecurity.controller;

import com.example.testsecurity.entity.UserEntity;
import com.example.testsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping ("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        UserEntity userEntity = userService.getUserEntity(id);
        if (userEntity != null) {
            userService.deleteUserEntity(id);
            return ResponseEntity.status(HttpStatus.FOUND).body("Пользователь успешно удален");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Пользователь не найден");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id){
        UserEntity userEntityRequestDto = userService.getUserEntity(id);
        return ResponseEntity.ok(userEntityRequestDto);
    }
}