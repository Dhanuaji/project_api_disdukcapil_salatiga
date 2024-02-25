package com.example.project_api.pegawai.data_pegawai.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project_api.pegawai.data_pegawai.entities.Pegawai;


@Repository
public interface PegawaiRepository extends JpaRepository<Pegawai, String>{
    
    Optional<Pegawai> findByUsername(String username);
    
}
