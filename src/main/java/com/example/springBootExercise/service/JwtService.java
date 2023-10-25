package com.example.springBootExercise.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.function.Function;

public interface JwtService
{
    String generateToken(String username);
    <T> T extraClaim(String token, Function<Claims,T> claimsResolver);
    Date extractExpirationTime(String token);
    Boolean validateToken(UserDetails userDetails, String token);
    String extractUsername(String token);
}
