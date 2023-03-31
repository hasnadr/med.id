package com.xa.miniproject313_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xa.miniproject313_api.models.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

    @Query(value = "SELECT b FROM Bank b WHERE isDeleted = false")
    List<Bank> getAllBank();

}
