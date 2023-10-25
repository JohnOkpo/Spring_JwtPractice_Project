package com.example.springBootExercise.config;

import com.example.springBootExercise.model.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AppUserUserDetails implements UserDetails
{
    String firstname = null;
    String lastname = null;
    String username = null;
    String password = null;
    List<GrantedAuthority> role;
    public AppUserUserDetails(AppUser user)
    {
        firstname = user.getFirstname();
        lastname = user.getLastname();
        username = user.getUsername();
        password = user.getPassword();
        role = Arrays.stream(user.getRole().toString().split(","))
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
