package com.example.project_api.pegawai.data_pegawai.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.project_api.exception.ResourceNotFoundException;
import com.example.project_api.pegawai.data_pegawai.dtos.LoginDto;
import com.example.project_api.pegawai.data_pegawai.dtos.PegawaiDto;
import com.example.project_api.pegawai.data_pegawai.entities.Pegawai;
import com.example.project_api.pegawai.data_pegawai.interfaces.PegawaiInterfaces;
import com.example.project_api.pegawai.data_pegawai.mapper.PegawaiMapper;
import com.example.project_api.pegawai.data_pegawai.repositories.PegawaiRepository;
import com.example.project_api.security.jwt_settings.model.AuthenticationResponse;
import com.example.project_api.security.jwt_settings.services.JwtService;

@Service
public class PegawaiService implements PegawaiInterfaces{

    @Autowired
    private PegawaiRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse addPegawai(PegawaiDto dto) {
        Pegawai entity = PegawaiMapper.mapToPegawai(dto);
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity.setIsactive(true);
        Pegawai addNewPegawai = repository.save(entity);

        String token = jwtService.generateToken(addNewPegawai);

        return new AuthenticationResponse(token);
    }

    @SuppressWarnings("null")
    @Override
    public PegawaiDto getPegawaiById(String id) {
        Pegawai entity = repository.findById(id)
            .orElseThrow(() -> 
                new ResourceNotFoundException("Pegawai tidak ditemukan untuk id : "+id));

        return PegawaiMapper.mapToPegawaiDto(entity);
    }

    @Override
    public List<PegawaiDto> getAllPegawai() {
        List<Pegawai> entities = repository.findAll();
        return entities.stream().map((entity) -> PegawaiMapper.mapToPegawaiDto(entity))
            .collect(Collectors.toList());
    }

    @SuppressWarnings("null")
    @Override
    public PegawaiDto editPegawai(String id, PegawaiDto dto) {
        Pegawai pegawai = repository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Pegawai tidak ditemukan untuk id : "+id)
        );

        pegawai.setNohp(dto.getNohp());
        pegawai.setAlamat(dto.getAlamat());

        Pegawai pegawaiUpdatedObj = repository.save(pegawai);

        return PegawaiMapper.mapToPegawaiDto(pegawaiUpdatedObj);
    }

    @SuppressWarnings({ "null", "unused" })
    @Override
    public void delete(String id) {
        Pegawai entity = repository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Pegawai tidak ditemukan dengan id : "+id)
        );
        repository.deleteById(id);
    }

    @Override
    public AuthenticationResponse authenticate(LoginDto dto) throws Exception{
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
            );            
        } catch (Exception e) {
            e.printStackTrace();
        }

        Pegawai pegawai = repository.findByUsername(dto.getUsername()).orElseThrow();
        String token = jwtService.generateToken(pegawai);

        return new AuthenticationResponse(token);
    }
    
}
