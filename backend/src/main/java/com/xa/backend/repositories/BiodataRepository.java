package com.xa.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xa.backend.models.Biodata;

@Repository
public interface BiodataRepository extends JpaRepository<Biodata, Long> {
    
}
