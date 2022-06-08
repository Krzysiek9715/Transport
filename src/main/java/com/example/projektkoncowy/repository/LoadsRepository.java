package com.example.projektkoncowy.repository;


import com.example.projektkoncowy.model.Loads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadsRepository extends JpaRepository<Loads, Long> {

        Loads findLoadsById(Long id);
}
