package com.xa.miniproject313_api.controllers;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xa.miniproject313_api.models.Biodata;
import com.xa.miniproject313_api.repositories.BiodataRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
public class BiodataController {

    @Autowired
    private BiodataRepository biodataRepo;

    @PostMapping("/savebiodata")
    public ResponseEntity<Biodata> saveBiodata(@RequestBody Biodata biodata) {
        try {
            // biodata.setIsDeleted(false);
            biodata.setCreatedOn(new Timestamp(System.currentTimeMillis()));
            this.biodataRepo.save(biodata);
            return new ResponseEntity<Biodata>(biodata, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Biodata>(HttpStatus.NO_CONTENT);
        }
    }

}
