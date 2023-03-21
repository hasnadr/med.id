package com.xa.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xa.backend.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
