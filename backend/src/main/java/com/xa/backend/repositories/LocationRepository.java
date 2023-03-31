package com.xa.backend.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xa.backend.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    @Query(value = "SELECT ml.* FROM m_location ml WHERE ml.is_delete = false", nativeQuery = true)
    List<Map<String, Object>> getAllLocation();
}
