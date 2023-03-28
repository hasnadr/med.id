package com.xa.backend.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xa.backend.models.DoctorOffice;

@Repository
public interface DoctorOfficeRepository extends JpaRepository<DoctorOffice, Long> {

    @Query(value = "SELECT o.* FROM doctor_office o WHERE o.is_delete = false", nativeQuery = true)
    List<DoctorOffice> getAllOffice();
    
    @Query(value = "SELECT " +
                    "ml.name AS lokasi, " +
                    "ml.id AS lokasi_id, " +
                    "mb.fullname AS nama_dokter, " + 
                    "ms.name AS spesialisasi, " + 
                    "ms.id AS spesialisasi_id, " + 
                    "EXTRACT('YEAR' FROM (current_date)) - EXTRACT('YEAR' FROM (tdo.created_on)) AS pengalaman, " +
                    "tdt.name AS tindakan_medis, " +
                    "tdt.id AS tindakan_id, " +
                    "mmf.name AS fasilitas_kesehatan " +
                    "FROM t_doctor_office tdo " +
                    "LEFT JOIN m_doctor md ON tdo.doctor_id = md.id " +
                    "LEFT JOIN m_biodata mb ON mb.id = md.biodata_id " +
                    "LEFT JOIN t_doctor_treatment tdt ON md.id = tdt.doctor_id " +
                    "LEFT JOIN m_medical_facility mmf ON tdo.faskes_id = mmf.id " +
                    "LEFT JOIN m_location ml ON ml.id = mmf.location_id " +
                    "LEFT JOIN t_current_doctor_specialization tcds ON tcds.doctor_id = md.id " +
                    "LEFT JOIN m_specialization ms ON ms.id = tcds.specialization_id " +
                    // "WHERE s.id = ?1 OR " +
                    // "WHERE l.id = ?1 OR " +
                    // "b.fullname ILIKE %?2% OR " +
                    // "s.id = ?3 OR " +
                    // "tm.id = ?4"
                    "WHERE ml.name ILIKE %?1% OR " +
                    "mb.fullname ILIKE %?2% OR " +
                    "ms.name ILIKE %?3% OR " +
                    "tdt.name ILIKE %?4%"
                    , nativeQuery= true)
    // List<Map<String, Object>> getSearchResult(Long lokasiId, String dokter, Long spId, Long tindakanId);
    List<Map<String, Object>> getSearchResult(String lokasi, String dokter, String sp, String tindakan);
    // List<Map<String, Object>> getSearchResult(Long spId);


}
