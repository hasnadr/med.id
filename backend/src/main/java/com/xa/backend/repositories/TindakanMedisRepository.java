package com.xa.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xa.backend.models.TindakanMedis;

@Repository
public interface TindakanMedisRepository extends JpaRepository<TindakanMedis, Long> {
    
}
