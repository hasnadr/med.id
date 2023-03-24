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

import com.xa.backend.models.Specialization;
import com.xa.backend.repositories.SpecializationRepository;

@RestController
@RequestMapping(value = "/")
@CrossOrigin("*")
public class SpecializationController {
    
    @Autowired private SpecializationRepository specializationRepo;

    @GetMapping("/getsp")
    public ResponseEntity<List<Specialization>> getAllSp() {
        try {
            List<Specialization> sp = this.specializationRepo.findAll();
            return new ResponseEntity<List<Specialization>>(sp, HttpStatus.OK);   
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Specialization>>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/savesp")
    public ResponseEntity<Specialization> insertSp(@RequestBody Specialization sp) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            sp.setCreatedOn(timestamp);
            this.specializationRepo.save(sp);
            return new ResponseEntity<Specialization>(sp, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Specialization>(HttpStatus.NO_CONTENT);
        }
    }

}
