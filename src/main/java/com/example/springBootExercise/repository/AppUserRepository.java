package com.example.springBootExercise.repository;

import com.example.springBootExercise.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long>
{
    Optional<AppUser> findByUsername(String username);
}
