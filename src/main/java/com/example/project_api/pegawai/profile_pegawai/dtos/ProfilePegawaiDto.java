package com.example.project_api.pegawai.profile_pegawai.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfilePegawaiDto {
    private String id;
    private String nik;
    private String nmlngkp;
    private String alamat;
    private String nohp;
    private String username;
}
