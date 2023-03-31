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

import com.xa.backend.models.FasilitasKesehatan;
import com.xa.backend.repositories.FasilitasKesehatanRepository;


@RestController
@RequestMapping(value = "/")
@CrossOrigin("*")
public class FaskesController {
 
    @Autowired private FasilitasKesehatanRepository faskesRepo;

    @GetMapping("/getfaskes")
    public ResponseEntity<List<FasilitasKesehatan>> getAllFaskes() {
        try {
            List<FasilitasKesehatan> faskes = this.faskesRepo.findAll();
            return new ResponseEntity<List<FasilitasKesehatan>>(faskes, HttpStatus.OK);   
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<FasilitasKesehatan>>(HttpStatus.NO_CONTENT);
        }
    }
    
    @PostMapping("/savefaskes")
    public ResponseEntity<FasilitasKesehatan> insertFaskes(@RequestBody FasilitasKesehatan faskes) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            faskes.setCreatedOn(timestamp);
            this.faskesRepo.save(faskes);
            return new ResponseEntity<FasilitasKesehatan>(faskes, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<FasilitasKesehatan>(HttpStatus.NO_CONTENT);
        }
    }
    
}
