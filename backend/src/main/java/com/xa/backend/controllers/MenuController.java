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

import com.xa.backend.models.Menu;
import com.xa.backend.repositories.MenuRepository;

@RestController
@RequestMapping(value = "/")
@CrossOrigin("*")
public class MenuController {
    @Autowired private MenuRepository menuRepo;

    @GetMapping("/getmenu")
    public ResponseEntity<List<Menu>> getAllMenu() {
        try {
            List<Menu> menu = this.menuRepo.findAll();
            return new ResponseEntity<List<Menu>>(menu, HttpStatus.OK);   
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Menu>>(HttpStatus.NO_CONTENT);
        }
    }
    
    @PostMapping("/savemenu")
    public ResponseEntity<Menu> insertMenu(@RequestBody Menu menu) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            menu.setCreatedOn(timestamp);
            this.menuRepo.save(menu);
            return new ResponseEntity<Menu>(menu, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Menu>(HttpStatus.NO_CONTENT);
        }
    }
}
