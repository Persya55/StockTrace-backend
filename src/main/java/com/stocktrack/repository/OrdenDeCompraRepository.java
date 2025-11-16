package com.stocktrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stocktrack.model.OrdenDeCompra;

@Repository
public interface OrdenDeCompraRepository extends JpaRepository <OrdenDeCompra, Long>{
    
}
