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

import com.xa.backend.models.DoctorOffice;
import com.xa.backend.repositories.DoctorOfficeRepository;

@RestController
@RequestMapping(value = "/")
@CrossOrigin("*")
public class DoctorOfficeController {
    
    @Autowired private DoctorOfficeRepository officeRepo;

    @GetMapping("/getoffice")
    public ResponseEntity<List<DoctorOffice>> getAllOffice() {
        try {
            List<DoctorOffice> office = this.officeRepo.findAll();
            return new ResponseEntity<List<DoctorOffice>>(office, HttpStatus.OK);   
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<DoctorOffice>>(HttpStatus.NO_CONTENT);
        }
    }
    
    @PostMapping("/saveoffice")
    public ResponseEntity<DoctorOffice> insertOffice(@RequestBody DoctorOffice office) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            office.setCreatedOn(timestamp);
            this.officeRepo.save(office);
            return new ResponseEntity<DoctorOffice>(office, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<DoctorOffice>(HttpStatus.NO_CONTENT);
        }
    }

}
