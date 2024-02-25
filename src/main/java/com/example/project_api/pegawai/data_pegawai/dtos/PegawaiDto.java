package com.example.project_api.pegawai.data_pegawai.dtos;

import com.example.project_api.pegawai.data_pegawai.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PegawaiDto {
    private String id;
    private String nik;
    private String nmlngkp;
    private String alamat;
    private String nohp;
    private String username;
    private String password;
    private Role role;
    private boolean isactive;
}
