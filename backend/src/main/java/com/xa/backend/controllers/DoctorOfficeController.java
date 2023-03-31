package com.xa.backend.controllers;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // @GetMapping("/search/{lokasiId}/{dokter}/{spId}/{tindakanId}")
    // public ResponseEntity<List<Map<String, Object>>> getSearchResult(
    //     @PathVariable("lokasiId") Long lokasiId,
    //     @PathVariable("dokter") String dokter,
    //     @PathVariable("spId") Long spId,
    //     @PathVariable("tindakanId") Long tindakanId
    // ) {
    //     try {
    //         List<Map<String, Object>> searchResult = this.officeRepo.getSearchResult(lokasiId, dokter, spId, tindakanId);
    //         return new ResponseEntity<List<Map<String, Object>>>(searchResult, HttpStatus.OK);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return new ResponseEntity<List<Map<String, Object>>>(HttpStatus.NO_CONTENT);
    //     }
    // }

    @GetMapping("/search/{lokasi}/{dokter}/{sp}/{tindakan}")
    public ResponseEntity<List<Map<String, Object>>> getSearchResult(
        @PathVariable("lokasi") String lokasi,
        @PathVariable("dokter") String dokter,
        @PathVariable("sp") String sp,
        @PathVariable("tindakan") String tindakan
    ) {
        try {
            List<Map<String, Object>> searchResult = this.officeRepo.getSearchResult(lokasi, dokter, sp, tindakan);
            return new ResponseEntity<List<Map<String, Object>>>(searchResult, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Map<String, Object>>>(HttpStatus.NO_CONTENT);
        }
    }


    // @GetMapping("/search/{spId}")
    // public ResponseEntity<List<Map<String, Object>>> getSearchResult(
    //     @PathVariable("spId") Long spId
    // ) {
    //     try {
    //         List<Map<String, Object>> searchResult = this.officeRepo.getSearchResult(spId);
    //         return new ResponseEntity<List<Map<String, Object>>>(searchResult, HttpStatus.OK);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return new ResponseEntity<List<Map<String, Object>>>(HttpStatus.NO_CONTENT);
    //     }
    // }

    @GetMapping("/search2/{lokasi}/{dokter}/{sp}/{tindakan}")
    public ResponseEntity<List<Map<String, Object>>> getResult(
        @PathVariable("lokasi") String lokasi,
        @PathVariable("dokter") String dokter,
        @PathVariable("sp") String sp,
        @PathVariable("tindakan") String tindakan
    ) {
        try {
            List<Map<String, Object>> searchResult = this.officeRepo.getResult(lokasi, dokter, sp, tindakan);
            return new ResponseEntity<List<Map<String, Object>>>(searchResult, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Map<String, Object>>>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/search2/{dokter}")
    public ResponseEntity<List<Map<String, Object>>> getFaskes(
        @PathVariable("dokter") String dokter
    ) {
        try {
            List<Map<String, Object>> searchResult = this.officeRepo.getFaskes(dokter);
            return new ResponseEntity<List<Map<String, Object>>>(searchResult, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Map<String, Object>>>(HttpStatus.NO_CONTENT);
        }
    }


}
