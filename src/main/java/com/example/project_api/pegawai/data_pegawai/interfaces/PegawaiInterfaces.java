package com.example.project_api.pegawai.data_pegawai.interfaces;

import java.util.List;

import com.example.project_api.pegawai.data_pegawai.dtos.LoginDto;
import com.example.project_api.pegawai.data_pegawai.dtos.PegawaiDto;
import com.example.project_api.security.jwt_settings.model.AuthenticationResponse;

public interface PegawaiInterfaces {
    public AuthenticationResponse addPegawai(PegawaiDto dto);
    public PegawaiDto getPegawaiById(String id);
    public List<PegawaiDto> getAllPegawai();
    public PegawaiDto editPegawai(String id, PegawaiDto dto);
    public void delete(String id);
    public AuthenticationResponse authenticate(LoginDto dto) throws Exception;
}
