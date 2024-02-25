package com.example.project_api.pegawai.data_pegawai.entities;

import com.example.project_api.security.Config.UserDetail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pegawai")
public class Pegawai extends UserDetail{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "nik", length = 50, unique = true)
    private String nik;

    @Column(name = "nmlngkp", length = 100)
    private String nmlngkp;

    @Column(name = "alamat", length = 100)
    private String alamat;

    @Column(name = "nohp", length = 20)
    private String nohp;

    @Column(name = "username", length = 20)
    private String username;

    @Column(name = "password", length = 255)
    private String password;

    @Enumerated(value = EnumType.STRING)
    Role role;

    @Column(name = "isactive")
    private boolean isactive;
}
