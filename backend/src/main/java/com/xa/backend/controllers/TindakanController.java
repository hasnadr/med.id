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

import com.xa.backend.models.TindakanMedis;
import com.xa.backend.repositories.TindakanMedisRepository;

@RestController
@RequestMapping(value = "/")
@CrossOrigin("*")
public class TindakanController {

    @Autowired private TindakanMedisRepository tindakanRepo;

    @GetMapping("/gettindakan")
    public ResponseEntity<List<TindakanMedis>> getAllTindakan() {
        try {
            List<TindakanMedis> tindakan = this.tindakanRepo.findAll();
            return new ResponseEntity<List<TindakanMedis>>(tindakan, HttpStatus.OK);   
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<TindakanMedis>>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/savetindakan")
    public ResponseEntity<TindakanMedis> insertTindakan(@RequestBody TindakanMedis tindakan) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            tindakan.setCreatedOn(timestamp);
            this.tindakanRepo.save(tindakan);
            return new ResponseEntity<TindakanMedis>(tindakan, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<TindakanMedis>(HttpStatus.NO_CONTENT);
        }
    }
}
