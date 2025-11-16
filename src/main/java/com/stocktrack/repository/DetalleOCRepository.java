package com.stocktrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stocktrack.model.DetalleOC;

@Repository
public interface DetalleOCRepository extends JpaRepository <DetalleOC, Long> {
    
}
