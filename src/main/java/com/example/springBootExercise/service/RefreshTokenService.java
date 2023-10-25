package com.example.springBootExercise.service;

import com.example.springBootExercise.model.AppUser;
import com.example.springBootExercise.model.RefreshToken;

import java.util.Optional;

public interface RefreshTokenService
{
    RefreshToken createRefreshToken(String username);
    Optional<RefreshToken> getRefreshToken(String refreshToken);
    RefreshToken verifyRefreshToken(RefreshToken token);

}
