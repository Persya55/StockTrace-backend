package com.stocktrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stocktrack.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository <Producto, Long> {
    
}
