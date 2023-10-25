package com.example.springBootExercise.service;

import com.example.springBootExercise.dto.AppUserDto;
import com.example.springBootExercise.model.AppUser;
import org.springframework.stereotype.Service;

public interface AppUserService
{
   AppUserDto createUser(AppUserDto userDto);
   AppUserDto getUser(Long id);
   AppUserDto getAllUsers();

}
