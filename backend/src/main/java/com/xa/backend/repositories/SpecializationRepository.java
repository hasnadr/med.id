package com.xa.backend.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xa.backend.models.Specialization;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
    @Query(value = "SELECT ms.* FROM m_specialization ms WHERE ms.is_delete = false", nativeQuery = true)
    List<Map<String, Object>> getAllSp();
}
