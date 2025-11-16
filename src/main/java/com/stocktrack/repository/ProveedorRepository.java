package com.stocktrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stocktrack.model.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository <Proveedor, Long> {
    
}
