package com.example.project_api.pegawai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project_api.pegawai.data_pegawai.dtos.LoginDto;
import com.example.project_api.pegawai.data_pegawai.dtos.PegawaiDto;
import com.example.project_api.pegawai.data_pegawai.services.PegawaiService;
import com.example.project_api.security.jwt_settings.model.AuthenticationResponse;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/disdukcapil-salatiga/pegawai")
public class PegawaiController {

    @Autowired
    private PegawaiService service;

    @GetMapping
    public ResponseEntity<List<PegawaiDto>> getAllPegawai() {
        List<PegawaiDto> dto = service.getAllPegawai();
        return ResponseEntity.ok(dto);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<PegawaiDto> getPegawaiById(@PathVariable("id") String id) {
        PegawaiDto dto = service.getPegawaiById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginDto dto) throws Exception {
        return ResponseEntity.ok(service.authenticate(dto));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> addPegawai(@RequestBody PegawaiDto dto) {
        return ResponseEntity.ok(service.addPegawai(dto));
    }

    @PutMapping("{id}")
    public ResponseEntity<PegawaiDto> editPegawai(@PathVariable("id") String id, @RequestBody PegawaiDto dto) {
        PegawaiDto updatedDto = service.editPegawai(id, dto);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id) {
        service.delete(id);
        return ResponseEntity.ok("Pegawai dengan id ("+id+") berhasil dihapus!");
    }
    
}
