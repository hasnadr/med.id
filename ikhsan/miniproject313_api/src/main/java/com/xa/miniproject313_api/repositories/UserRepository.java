package com.xa.miniproject313_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xa.miniproject313_api.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT CASE WHEN COUNT(email) > 0 THEN true ELSE false END FROM User u WHERE u.email = ?1")
    Boolean emailExists(String email);

    @Query(value = "SELECT * FROM users u WHERE u.email = ?1", nativeQuery = true)
    List<User> findUserByEmail(String email);

    User findByEmail(String email);

}
