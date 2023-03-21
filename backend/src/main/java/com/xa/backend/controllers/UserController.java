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

import com.xa.backend.models.User;
import com.xa.backend.repositories.UserRepository;

@RestController
@RequestMapping(value = "/")
@CrossOrigin("*")
public class UserController {
    @Autowired private UserRepository userRepo;

    @GetMapping("/getuser")
    public ResponseEntity<List<User>> getAllUser() {
        try {
            List<User> user = this.userRepo.findAll();
            return new ResponseEntity<List<User>>(user, HttpStatus.OK);   
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
    }
    
    @PostMapping("/saveuser")
    public ResponseEntity<User> insertUser(@RequestBody User user) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            user.setCreatedOn(timestamp);
            this.userRepo.save(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }
    }
}
