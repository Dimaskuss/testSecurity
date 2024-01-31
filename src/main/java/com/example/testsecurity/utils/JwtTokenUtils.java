package com.example.testsecurity.utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class JwtTokenUtils {
@Value("${jwt.secret}")
    private String secret;

@Value("${jwt.expiration}")
    private Duration expiration;

}