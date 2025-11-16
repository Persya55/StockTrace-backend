package com.stocktrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stocktrack.model.Contenedor;

@Repository
public interface ContenedorRepository extends JpaRepository <Contenedor, Long> {
    
}
