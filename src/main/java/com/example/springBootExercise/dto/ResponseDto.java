package com.example.springBootExercise.dto;


import com.example.springBootExercise.model.RefreshToken;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto
{
    private String accessToken;
    private String token;
}
