package com.example.springBootExercise.controller;

import com.example.springBootExercise.dto.RequestDto;
import com.example.springBootExercise.dto.ResponseDto;
import com.example.springBootExercise.model.RefreshToken;
import com.example.springBootExercise.service.impl.JwtServiceImpl;
import com.example.springBootExercise.service.impl.RefreshTokenServiceImp;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test-auth")
public class AuthController
{
    @Autowired
    private JwtServiceImpl jwtService;

    @Autowired
    private RefreshTokenServiceImp tokenServiceImp;

    @PostMapping("/login")
    public ResponseDto login(@RequestBody  RequestDto requestDto)
    {
        Logger logger = LoggerFactory.getLogger(AuthController.class);
        logger.info(requestDto.getUsername());
        RefreshToken accessToken = tokenServiceImp.createRefreshToken(requestDto.getUsername());
        return ResponseDto.builder()
                .accessToken(jwtService.generateToken(requestDto.getUsername()))
                .token(accessToken.getToken())
                .build();

    }
}
