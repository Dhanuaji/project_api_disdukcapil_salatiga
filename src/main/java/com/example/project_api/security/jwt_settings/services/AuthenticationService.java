package com.example.project_api.security.jwt_settings.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.project_api.pegawai.data_pegawai.entities.Pegawai;
import com.example.project_api.pegawai.data_pegawai.repositories.PegawaiRepository;

@Service
public class AuthenticationService {
    
    @Autowired
    private PegawaiRepository pegawaiRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    // public AuthenticationResponse register(Pegawai request) {
    //     Pegawai entity = new Pegawai();
    //     entity.setNik(request.getNik());;
    //     entity.setNmlngkp(request.getNmlngkp());
    //     entity.setAlamat(request.getAlamat());
    //     entity.setNohp(request.getNohp());
    //     entity.setUsername(request.getUsername());
    //     entity.setPassword(passwordEncoder.encode(request.getPassword()));
    //     entity.setIsactive(true);
    //     entity.setRole(entity.getRole());
    // }
}
