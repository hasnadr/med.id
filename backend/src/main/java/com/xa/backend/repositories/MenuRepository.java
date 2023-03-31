package com.xa.backend.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xa.backend.models.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    
    @Query(value = "SELECT mm.* FROM m_menu mm WHERE mm.is_delete = false", nativeQuery = true)
    List<Menu> getAllMenu();

    @Query(value = "SELECT mm.name, mmr.role_id, mm.big_icon, mm.url, mm.id " +
    "FROM m_menu mm " +
    "LEFT JOIN m_menu_role mmr ON mm.id = mmr.menu_id " +
    "WHERE mmr.role_id = ?1 AND mm.parent_id ISNULL", nativeQuery = true)
    List<Map<String, Object>> getParentMenu(Long roleId);

    @Query(value = "SELECT mm.name, mmr.role_id, mm.big_icon, mm.id " +
    "FROM m_menu mm " +
    "LEFT JOIN m_menu_role mmr ON mm.id = mmr.menu_id " +
    "WHERE mmr.role_id = ?1 AND mm.parent_id = ?2", nativeQuery = true)
    List<Map<String, Object>> getSubMenu(Long roleId, Long parentId);

    // @Query(value = "SELECT m.name" +
    // "FROM menu m " +
    // "LEFT JOIN menu_role mr ON m.id = mr.menu_id " +
    // "WHERE mr.role_id = 5 AND m.parent_id ISNULL", nativeQuery = true)
    //  List<Map<String, Object>> getPublicMenu();

}
