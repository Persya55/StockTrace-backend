package com.stocktrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stocktrack.model.MovimientoLote;

@Repository
public interface MovimientoLoteRepository extends JpaRepository <MovimientoLote, Long> {
    
}
