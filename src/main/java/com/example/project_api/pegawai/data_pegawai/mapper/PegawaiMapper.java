package com.example.project_api.pegawai.data_pegawai.mapper;

import com.example.project_api.pegawai.data_pegawai.dtos.PegawaiDto;
import com.example.project_api.pegawai.data_pegawai.entities.Pegawai;

public class PegawaiMapper {
    
    public static PegawaiDto mapToPegawaiDto(Pegawai entity) {
        return new PegawaiDto(
            entity.getId(),
            entity.getNik(),
            entity.getNmlngkp(),
            entity.getAlamat(),
            entity.getNohp(),
            entity.getUsername(),
            entity.getPassword(),
            entity.getRole(),
            entity.isIsactive()
        );
    }

    public static Pegawai mapToPegawai(PegawaiDto dto) {
        return new Pegawai(
            dto.getId(),
            dto.getNik(),
            dto.getNmlngkp(),
            dto.getAlamat(),
            dto.getNohp(),
            dto.getUsername(),
            dto.getPassword(),
            dto.getRole(),
            dto.isIsactive()
        );
    }
}
