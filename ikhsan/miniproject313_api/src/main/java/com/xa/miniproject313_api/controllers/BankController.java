package com.xa.miniproject313_api.controllers;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xa.miniproject313_api.models.Bank;
import com.xa.miniproject313_api.repositories.BankRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
public class BankController {

    @Autowired
    private BankRepository bankRepo;

    @GetMapping("/bank")
    public ResponseEntity<List<Bank>> getAllBank() {
        try {
            List<Bank> bank = this.bankRepo.getAllBank();
            return new ResponseEntity<List<Bank>>(bank, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Bank>>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/savebank")
    public ResponseEntity<Bank> insertBank(@RequestBody Bank bank) {
        try {
            bank.setCreatedOn(new Timestamp(System.currentTimeMillis()));
            this.bankRepo.save(bank);
            return new ResponseEntity<Bank>(bank, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Bank>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/bank/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {
        try {
            Bank bank = this.bankRepo.findById(id).orElse(null);
            if (bank != null) {
                return new ResponseEntity<Bank>(bank, HttpStatus.OK);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("bank not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Bank>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/bank/{id}")
    public ResponseEntity<Bank> editBank(
            @RequestBody Bank bank,
            @PathVariable("id") Long id) {
        try {
            bank.setId(id);
            bank.setModifiedOn(new Timestamp(System.currentTimeMillis()));
            this.bankRepo.save(bank);
            return new ResponseEntity<Bank>(bank, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Bank>(HttpStatus.NO_CONTENT);
        }

    }

    @PutMapping("deletebank/{id}")
    public ResponseEntity<Bank> deleteBank(@PathVariable("id") Long id, @RequestBody Long deletedBy) {
        try {
            Bank bank = this.bankRepo.findById(id).orElse(null);
            if (bank != null) {
                bank.setDeletedOn(new Timestamp(System.currentTimeMillis()));
                bank.setDeletedBy(deletedBy);
                bank.setDeleted(true);
                this.bankRepo.save(bank);
                return new ResponseEntity<Bank>(bank, HttpStatus.OK);
            } else {
                return new ResponseEntity<Bank>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<Bank>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
