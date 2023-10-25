package com.example.springBootExercise.service.impl;

import com.example.springBootExercise.model.AppUser;
import com.example.springBootExercise.model.RefreshToken;
import com.example.springBootExercise.repository.AppUserRepository;
import com.example.springBootExercise.repository.RefreshTokenRepository;
import com.example.springBootExercise.service.RefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenServiceImp implements RefreshTokenService {

    @Autowired
    private AppUserRepository userRepository;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Override
    public RefreshToken createRefreshToken(String username) {

        RefreshToken refreshToken = RefreshToken.builder()
                .token(UUID.randomUUID().toString())
                .expiryTime(Instant.now().plusMillis(60000))
                .userInfo(userRepository.findByUsername(username).get())
                .build();

        return refreshTokenRepository.save(refreshToken);
    }

    @Override
    public Optional<RefreshToken> getRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByToken(refreshToken);
    }

    @Override
    public RefreshToken verifyRefreshToken(RefreshToken token) {
       if(token.getExpiryTime().compareTo(Instant.now()) < 0)
       {
           refreshTokenRepository.delete(token);
           throw new RuntimeException("Invalid Token");
       }

       return token;
    }
}
