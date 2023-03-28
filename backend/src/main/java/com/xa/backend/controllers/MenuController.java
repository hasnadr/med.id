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
            List<Menu> menu = this.menuRepo.getAllMenu();
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

    @GetMapping("/menu/{role_id}")
    public ResponseEntity<List<Map<String, Object>>> getParentMenu(
        @PathVariable("role_id") Long roleId
    ) {
        try {
            List<Map<String, Object>> menuRole = this.menuRepo.getParentMenu(roleId);
            return new ResponseEntity<List<Map<String, Object>>>(menuRole, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Map<String, Object>>>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/menu/{role_id}/{parent_id}")
    public ResponseEntity<List<Map<String, Object>>> getMenu(
        @PathVariable("role_id") Long roleId,
        @PathVariable("parent_id") Long parentId
    ) {
        try {
            List<Map<String, Object>> menuRole = this.menuRepo.getSubMenu(roleId, parentId);
            return new ResponseEntity<List<Map<String, Object>>>(menuRole, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Map<String, Object>>>(HttpStatus.NO_CONTENT);
        }
    }

    // @GetMapping("/publicmenu")
    // public ResponseEntity<List<Map<String, Object>>> getPublicMenu() {
    //     try {
    //         List<Map<String, Object>> menuRole = this.menuRepo.getPublicMenu();
    //         return new ResponseEntity<List<Map<String, Object>>>(menuRole, HttpStatus.OK);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return new ResponseEntity<List<Map<String, Object>>>(HttpStatus.NO_CONTENT);
    //     }
    // }
}
