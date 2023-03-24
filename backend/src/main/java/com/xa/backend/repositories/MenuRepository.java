package com.xa.backend.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xa.backend.models.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    
    @Query(value = "SELECT m.* FROM menu m WHERE m.is_delete = false", nativeQuery = true)
    List<Menu> getAllMenu();

    @Query(value = "SELECT m.name, mr.role_id, m.big_icon, m.url, m.id " +
    "FROM menu m " +
    "LEFT JOIN menu_role mr ON m.id = mr.menu_id " +
    "WHERE mr.role_id = ?1 AND m.parent_id ISNULL", nativeQuery = true)
    List<Map<String, Object>> getParentMenu(Long roleId);

    @Query(value = "SELECT m.name, mr.role_id, m.big_icon " +
    "FROM menu m " +
    "LEFT JOIN menu_role mr ON m.id = mr.menu_id " +
    "WHERE mr.role_id = ?1 AND m.parent_id = ?2", nativeQuery = true)
    List<Map<String, Object>> getSubMenu(Long roleId, Long parentId);

    // @Query(value = "SELECT m.name" +
    // "FROM menu m " +
    // "LEFT JOIN menu_role mr ON m.id = mr.menu_id " +
    // "WHERE mr.role_id = 5 AND m.parent_id ISNULL", nativeQuery = true)
    //  List<Map<String, Object>> getPublicMenu();

}
