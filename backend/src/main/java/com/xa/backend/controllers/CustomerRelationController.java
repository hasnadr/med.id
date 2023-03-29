package com.xa.backend.controllers;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xa.backend.models.CustomerRelation;
import com.xa.backend.repositories.CustomerRelationRepository;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class CustomerRelationController {
    
    @Autowired private CustomerRelationRepository customerRelationRepo;

    @GetMapping("/getrelation")
    public ResponseEntity<List<Map<String, Object>>> getAllRelation() {
        try {
            List<Map<String, Object>> sp = this.customerRelationRepo.getAllRelation();
            return new ResponseEntity<List<Map<String, Object>>>(sp, HttpStatus.OK);   
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Map<String, Object>>>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/saverelation")
    public ResponseEntity<CustomerRelation> insertRelation(@RequestBody CustomerRelation relation) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            relation.setCreatedOn(timestamp);
            this.customerRelationRepo.save(relation);
            return new ResponseEntity<CustomerRelation>(relation, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<CustomerRelation>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/editrelation/{id}")
    public ResponseEntity<CustomerRelation> edititemCategory(
            @RequestBody CustomerRelation relation,
            @PathVariable("id") Long id) {
        try {
            CustomerRelation _relation = this.customerRelationRepo.findById(id).orElse(null);
            _relation.setModifiedOn(new Timestamp(System.currentTimeMillis()));
            _relation.setModifiedBy(Long.parseLong("1"));
            _relation.setName(relation.getName());
            this.customerRelationRepo.save(_relation);
            return new ResponseEntity<CustomerRelation>(relation, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<CustomerRelation>(HttpStatus.NO_CONTENT);

        }
    }

    @DeleteMapping("/deleterelation/{id}")
    public ResponseEntity<?> deleteitemcategory(@PathVariable("id") Long id) {
        try {
            CustomerRelation relation = this.customerRelationRepo.findById(id).orElse(null);
            if (relation != null) {
                // this.itemcategoryRepo.deleteById(id);
                CustomerRelation _relation = this.customerRelationRepo.findById(id).orElse(null);
                _relation.setDeletedOn(new Timestamp(System.currentTimeMillis()));
                _relation.setDeletedBy(Long.parseLong("1"));
                _relation.setDeleted(true);
                this.customerRelationRepo.save(_relation);
                return ResponseEntity.status(HttpStatus.OK).body("Relation deleted!");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Deleted failed");
            }

        } catch (Exception e) {
            return new ResponseEntity<CustomerRelation>(HttpStatus.NO_CONTENT);

        }
    }

    @GetMapping("/relation/{name}")
    public ResponseEntity<List<Map<String, Object>>> searchRelation(
        @PathVariable("name") String name
    ) {
        try {
            List<Map<String, Object>> relation = this.customerRelationRepo.searchRelation(name);
            return new ResponseEntity<List<Map<String, Object>>>(relation, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Map<String, Object>>>(HttpStatus.NO_CONTENT);
        }
    }

}
