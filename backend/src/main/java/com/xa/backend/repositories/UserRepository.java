package com.xa.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xa.backend.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
