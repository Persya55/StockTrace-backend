package com.stocktrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stocktrack.model.Ubicacion;

@Repository
public interface UbicacionRepository extends JpaRepository <Ubicacion, Long> {
    
}
