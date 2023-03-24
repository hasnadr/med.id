package com.xa.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xa.backend.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    
}
