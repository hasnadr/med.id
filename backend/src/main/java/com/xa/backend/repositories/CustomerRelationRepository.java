package com.xa.backend.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xa.backend.models.CustomerRelation;

@Repository
public interface CustomerRelationRepository extends JpaRepository<CustomerRelation, Long> {
    
    @Query(value = "SELECT mcr.* FROM m_customer_relation mcr WHERE mcr.is_delete = false", nativeQuery = true)
    List<Map<String, Object>> getAllRelation();

    @Query(value = "SELECT mcr.* FROM m_customer_relation mcr WHERE mcr.name ILIKE %?1%", nativeQuery = true)
    List<Map<String, Object>> getRelationByName(String name);

    @Query(value = "SELECT mcr.name, mcr.id FROM m_customer_relation mcr WHERE mcr.id = ?1", nativeQuery = true)
    List<Map<String, Object>> getRelationById(Long id);
}
