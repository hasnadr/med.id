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

import com.xa.backend.models.Doctor;
import com.xa.backend.repositories.DoctorRepository;

@RestController
@RequestMapping(value = "/")
@CrossOrigin("*")
public class DoctorController {
    
    @Autowired private DoctorRepository doctorRepo;

    @GetMapping("/getdoctor")
    public ResponseEntity<List<Doctor>> getAllDoctor() {
        try {
            List<Doctor> doctor = this.doctorRepo.findAll();
            return new ResponseEntity<List<Doctor>>(doctor, HttpStatus.OK);   
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Doctor>>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/savedoctor")
    public ResponseEntity<Doctor> insertDoctor(@RequestBody Doctor doctor) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            doctor.setCreatedOn(timestamp);
            this.doctorRepo.save(doctor);
            return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Doctor>(HttpStatus.NO_CONTENT);
        }
    }

}
