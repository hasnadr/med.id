package com.xa.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xa.backend.models.DoctorOffice;

@Repository
public interface DoctorOfficeRepository extends JpaRepository<DoctorOffice, Long> {
    
}
