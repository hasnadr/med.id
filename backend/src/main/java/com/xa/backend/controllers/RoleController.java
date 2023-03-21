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

import com.xa.backend.models.Role;
import com.xa.backend.repositories.RoleRepository;

@RestController
@RequestMapping(value = "/")
@CrossOrigin("*")
public class RoleController {
    
    @Autowired private RoleRepository roleRepo;

    @GetMapping("/getrole")
    public ResponseEntity<List<Role>> getAllRole() {
        try {
            List<Role> role = this.roleRepo.findAll();
            return new ResponseEntity<List<Role>>(role, HttpStatus.OK);   
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Role>>(HttpStatus.NO_CONTENT);
        }
    }
    
    @PostMapping("/saverole")
    public ResponseEntity<Role> insertRole(@RequestBody Role role) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            role.setCreatedOn(timestamp);
            this.roleRepo.save(role);
            return new ResponseEntity<Role>(role, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Role>(HttpStatus.NO_CONTENT);
        }
    }

}
