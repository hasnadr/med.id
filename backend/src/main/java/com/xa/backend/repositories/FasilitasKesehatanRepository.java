package com.xa.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xa.backend.models.FasilitasKesehatan;

@Repository
public interface FasilitasKesehatanRepository extends JpaRepository<FasilitasKesehatan, Long> {
    
}
