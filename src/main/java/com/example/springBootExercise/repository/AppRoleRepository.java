package com.example.springBootExercise.repository;

import com.example.springBootExercise.model.AppUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppUserRole, Long>
{

}
