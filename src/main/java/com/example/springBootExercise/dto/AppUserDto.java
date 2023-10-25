package com.example.springBootExercise.dto;

import com.example.springBootExercise.model.AppUserRole;
import jakarta.persistence.*;

public class AppUserDto
{
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private AppUserRole role;

}
