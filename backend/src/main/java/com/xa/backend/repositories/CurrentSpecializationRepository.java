package com.xa.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xa.backend.models.CurrentSpecialization;

@Repository
public interface CurrentSpecializationRepository extends JpaRepository<CurrentSpecialization, Long> {
    
}
