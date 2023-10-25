package com.example.springBootExercise.config;

import com.example.springBootExercise.model.AppUser;
import com.example.springBootExercise.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AppUserUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser>  user = userRepository.findByUsername(username);
                return user.map(AppUserUserDetails::new).orElseThrow(()-> new RuntimeException("There is an issue"));
    }
}
