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

import com.xa.backend.models.Location;
import com.xa.backend.repositories.LocationRepository;

@RestController
@RequestMapping(value = "/")
@CrossOrigin("*")
public class LokasiController {
    
    @Autowired private LocationRepository locationRepo;

    @GetMapping("/getlocation")
    public ResponseEntity<List<Location>> getAllLocation() {
        try {
            List<Location> location = this.locationRepo.findAll();
            return new ResponseEntity<List<Location>>(location, HttpStatus.OK);   
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Location>>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/savelocation")
    public ResponseEntity<Location> insertLocation(@RequestBody Location location) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            location.setCreatedOn(timestamp);
            this.locationRepo.save(location);
            return new ResponseEntity<Location>(location, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Location>(HttpStatus.NO_CONTENT);
        }
    }

}
