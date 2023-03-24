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

import com.xa.backend.models.CurrentSpecialization;
import com.xa.backend.repositories.CurrentSpecializationRepository;

@RestController
@RequestMapping(value = "/")
@CrossOrigin("*")
public class CurrentSpecializationController {
    
    @Autowired private CurrentSpecializationRepository currentSpRepo;

    @GetMapping("/getcurrentsp")
    public ResponseEntity<List<CurrentSpecialization>> getAllCurrentSp() {
        try {
            List<CurrentSpecialization> currentsp = this.currentSpRepo.findAll();
            return new ResponseEntity<List<CurrentSpecialization>>(currentsp, HttpStatus.OK);   
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<CurrentSpecialization>>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/savecurrentsp")
    public ResponseEntity<CurrentSpecialization> insertCurrentSp(@RequestBody CurrentSpecialization currentsp) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            currentsp.setCreatedOn(timestamp);
            this.currentSpRepo.save(currentsp);
            return new ResponseEntity<CurrentSpecialization>(currentsp, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<CurrentSpecialization>(HttpStatus.NO_CONTENT);
        }
    }

}
