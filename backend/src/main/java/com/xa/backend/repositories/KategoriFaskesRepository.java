package com.xa.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xa.backend.models.KategoriFaskes;

@Repository
public interface KategoriFaskesRepository extends JpaRepository<KategoriFaskes, Long> {
    
}
