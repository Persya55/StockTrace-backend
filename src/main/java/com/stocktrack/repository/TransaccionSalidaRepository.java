package com.stocktrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stocktrack.model.TransaccionSalida;

@Repository
public interface TransaccionSalidaRepository extends JpaRepository <TransaccionSalida, Long>{
    
}
