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

import com.xa.backend.models.MenuRole;
import com.xa.backend.repositories.MenuRoleRepository;

@RestController
@RequestMapping(value = "/")
@CrossOrigin("*")
public class MenuRoleController {
    @Autowired private MenuRoleRepository menuroleRepo;

    @GetMapping("/getmenurole")
    public ResponseEntity<List<MenuRole>> getAllMenuRole() {
        try {
            List<MenuRole> menurole = this.menuroleRepo.findAll();
            return new ResponseEntity<List<MenuRole>>(menurole, HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<MenuRole>>(HttpStatus.NO_CONTENT);
        }
    }
    
    @PostMapping("/savemenurole")
    public ResponseEntity<MenuRole> insertMenuRole(@RequestBody MenuRole menurole) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            menurole.setCreatedOn(timestamp);
            this.menuroleRepo.save(menurole);
            return new ResponseEntity<MenuRole>(menurole, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<MenuRole>(HttpStatus.NO_CONTENT);
        }
    }
}
