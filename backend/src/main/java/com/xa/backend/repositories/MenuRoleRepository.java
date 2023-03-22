package com.xa.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xa.backend.models.MenuRole;

@Repository
public interface MenuRoleRepository extends JpaRepository<MenuRole, Long> {
   

}
