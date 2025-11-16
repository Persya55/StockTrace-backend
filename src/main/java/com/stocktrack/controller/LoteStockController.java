package com.stocktrack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocktrack.dto.LoteStockResponseDTO;
import com.stocktrack.services.LoteStockService;

@RestController
@RequestMapping("/lotes-stock")
@CrossOrigin(origins = "*")
public class LoteStockController {

    @Autowired
    private LoteStockService loteStockService;


    @GetMapping
    public ResponseEntity<List<LoteStockResponseDTO>> getInventarioDashboard() {
        List<LoteStockResponseDTO> inventario = loteStockService.getInventarioDashboard();
        return ResponseEntity.ok(inventario);
    }
}

