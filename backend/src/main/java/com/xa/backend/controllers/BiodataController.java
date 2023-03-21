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

import com.xa.backend.models.Biodata;
import com.xa.backend.repositories.BiodataRepository;

@RestController
@RequestMapping(value = "/")
@CrossOrigin("*")
public class BiodataController {
    @Autowired private BiodataRepository biodataRepo;

    @GetMapping("/getbiodata")
    public ResponseEntity<List<Biodata>> getAllBiodata() {
        try {
            List<Biodata> biodata = this.biodataRepo.findAll();
            return new ResponseEntity<List<Biodata>>(biodata, HttpStatus.OK);   
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Biodata>>(HttpStatus.NO_CONTENT);
        }
    }
    
    @PostMapping("/savebiodata")
    public ResponseEntity<Biodata> insertBiodata(@RequestBody Biodata biodata) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            biodata.setCreatedOn(timestamp);
            this.biodataRepo.save(biodata);
            return new ResponseEntity<Biodata>(biodata, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Biodata>(HttpStatus.NO_CONTENT);
        }
    }
}
