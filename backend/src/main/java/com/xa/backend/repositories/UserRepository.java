package com.xa.backend.repositories;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xa.backend.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT b.fullname, u.role_id " +
    "FROM usermenu u " +
    "LEFT JOIN biodata b ON b.id = u.biodata_id " +
    "WHERE u.role_id = ?1", nativeQuery = true)
    List<Map<String, Object>> findByRoleId(Long roleId);

}
