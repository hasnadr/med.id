package com.xa.backend.controllers;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xa.backend.models.KategoriFaskes;
import com.xa.backend.repositories.KategoriFaskesRepository;

@RestController
@RequestMapping(value = "/")
@CrossOrigin("*")
public class KategoriFaskesController {
    
    @Autowired private KategoriFaskesRepository kategoriFaskesRepo;

    @GetMapping("/getkategori")
    public ResponseEntity<List<KategoriFaskes>> getAllKategori() {
        try {
            List<KategoriFaskes> kategori = this.kategoriFaskesRepo.findAll();
            return new ResponseEntity<List<KategoriFaskes>>(kategori, HttpStatus.OK); 
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<KategoriFaskes>>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/savekategori")
    public ResponseEntity<KategoriFaskes> insertKategori(@RequestBody KategoriFaskes kategori) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            kategori.setCreatedOn(timestamp);
            this.kategoriFaskesRepo.save(kategori);
            return new ResponseEntity<KategoriFaskes>(kategori, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<KategoriFaskes>(HttpStatus.NO_CONTENT);
        }
    }

}
