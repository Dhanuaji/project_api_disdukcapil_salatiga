package com.example.project_api.pegawai.profile_pegawai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.project_api.pegawai.data_pegawai.entities.Pegawai;
import com.example.project_api.pegawai.profile_pegawai.dtos.ProfilePegawaiDto;

public interface ProfilePegawaiRepository extends JpaRepository<Pegawai, String>{
    
    @Query("")
    public ProfilePegawaiDto getDataPegawaiByNik(String nik);
}
