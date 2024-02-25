package com.example.project_api.security.Config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.project_api.pegawai.data_pegawai.entities.Pegawai;
import com.example.project_api.pegawai.data_pegawai.entities.Role;

public class UserDetail implements UserDetails {

    private static Role role;

    private static Pegawai pegawai;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return pegawai.getPassword();
    }

    @Override
    public String getUsername() {
        return pegawai.getUsername();
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
