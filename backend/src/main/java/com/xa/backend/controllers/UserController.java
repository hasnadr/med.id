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

import com.xa.backend.models.Biodata;
import com.xa.backend.models.User;
import com.xa.backend.repositories.BiodataRepository;
import com.xa.backend.repositories.UserRepository;

@RestController
@RequestMapping(value = "/")
@CrossOrigin("*")
public class UserController {
    @Autowired private UserRepository userRepo;
    @Autowired private BiodataRepository biodataRepo;

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
            user.setCreatedBy(user.getId());
            this.userRepo.save(user);
            Biodata biodata = biodataRepo.findById(user.getBiodataId()).get();
            biodata.setCreatedBy(user.getId());
            this.biodataRepo.save(biodata);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/user/{role_id}")
    public ResponseEntity<List<Map<String, Object>>> findByRoleId(
        @PathVariable("role_id") Long roleId
    ) {
        try {
            List<Map<String, Object>> menuRole = this.userRepo.findByRoleId(roleId);
            return new ResponseEntity<List<Map<String, Object>>>(menuRole, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Map<String, Object>>>(HttpStatus.NO_CONTENT);
        }
    }

}
