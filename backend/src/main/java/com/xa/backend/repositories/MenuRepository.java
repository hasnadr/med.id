package com.xa.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xa.backend.models.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    
}
