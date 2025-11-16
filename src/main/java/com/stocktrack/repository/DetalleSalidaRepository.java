package com.stocktrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stocktrack.model.DetalleSalida;

@Repository
public interface DetalleSalidaRepository extends JpaRepository <DetalleSalida, Long> {
    
}
