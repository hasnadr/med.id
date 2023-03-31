package com.xa.backend.repositories;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xa.backend.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT mb.fullname, mu.role_id " +
    "FROM m_user mu " +
    "LEFT JOIN m_biodata mb ON mb.id = mu.biodata_id " +
    "WHERE mu.role_id = ?1", nativeQuery = true)
    List<Map<String, Object>> findByRoleId(Long roleId);

}
