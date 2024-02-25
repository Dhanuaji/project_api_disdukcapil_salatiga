package com.example.project_api.security.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.project_api.exception.UserNotFoundException;
import com.example.project_api.pegawai.data_pegawai.repositories.PegawaiRepository;

@Service
public class UserDetailsImpl implements UserDetailsService {

    @Autowired
    PegawaiRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return repository.findByUsername(username)
            .orElseThrow(() -> new UserNotFoundException("User with this username ("+username+") not found."));
    }
    
}
