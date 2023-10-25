package com.example.springBootExercise.service.impl;

import com.example.springBootExercise.repository.AppUserRepository;
import com.example.springBootExercise.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtServiceImpl implements JwtService {


    private String createToken(Map<String, Object> claims, String username)
    {
        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("iOtech")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*300*60))
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS512, "termingService")
                .compact();
    }

    private Boolean isTokenExpired(String token)
    {
        return extractExpirationTime(token).before(new Date());
    }

    private Claims extractAllClaims(String token)
    {
        return Jwts.parser().setSigningKey("termingService").parseClaimsJws(token).getBody();
    }

    @Override
    public String generateToken(String username)
    {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    @Override
    public <T> T extraClaim(String token, Function<Claims,T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    @Override
    public Date extractExpirationTime(String token) {
        return extraClaim(token, Claims::getExpiration);
    }

    @Override
    public Boolean validateToken(UserDetails userDetails, String token) {
        String user = extractUsername(token);
        return (user.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    @Override
    public String extractUsername(String token) {
        return extraClaim(token, Claims::getSubject);
    }
}
