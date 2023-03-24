package com.xa.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xa.backend.models.Specialization;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
    
}
