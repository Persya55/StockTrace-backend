package com.stocktrack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stocktrack.model.LoteStock;

@Repository
public interface LoteStockRepository extends JpaRepository <LoteStock, Long> {
    
List<LoteStock> findByProductoIdAndCantidadActualGreaterThanOrderByFechaCaducidadAsc(Long productoId, Integer cantidad);}
