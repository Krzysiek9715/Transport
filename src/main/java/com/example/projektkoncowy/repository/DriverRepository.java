package com.example.projektkoncowy.repository;

import com.example.projektkoncowy.model.Drivers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Drivers, Long> {



}
