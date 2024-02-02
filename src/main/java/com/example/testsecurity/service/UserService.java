package com.example.testsecurity.service;

import com.example.testsecurity.dto.UserEntityRequestDto;
import com.example.testsecurity.entity.UserEntity;
import com.example.testsecurity.repository.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Builder
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

     private final BCryptPasswordEncoder passwordEncoder;



    public void saveUser(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);
    }

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }
    public UserEntity getUserEntity(Long id){
        return userRepository.findFirstById(id);
//        return UserEntityRequestDto.builder().name(userEntity.getName()).email(userEntity.getEmail()).build();
    }

    public void deleteUserEntity(Long id) {
        userRepository.deleteById(id);
    }


}
