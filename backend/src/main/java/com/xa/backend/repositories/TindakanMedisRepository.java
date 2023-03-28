package com.xa.backend.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xa.backend.models.TindakanMedis;

@Repository
public interface TindakanMedisRepository extends JpaRepository<TindakanMedis, Long> {
    @Query(value = "SELECT tdt.* FROM t_doctor_treatment tdt WHERE tdt.is_delete = false", nativeQuery = true)
    List<Map<String, Object>> getAllSp();
}
