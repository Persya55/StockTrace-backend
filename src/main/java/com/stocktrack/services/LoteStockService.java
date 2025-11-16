package com.stocktrack.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktrack.dto.LoteStockResponseDTO;
import com.stocktrack.model.LoteStock;
import com.stocktrack.repository.LoteStockRepository;

@Service
public class LoteStockService {
    
    @Autowired
    private LoteStockRepository loteStockRepository;

    public List<LoteStockResponseDTO> getInventarioDashboard() {
        List<LoteStock> lotes = loteStockRepository.findAll();
        
        return lotes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    private LoteStockResponseDTO convertToDTO(LoteStock lote) {
        LoteStockResponseDTO dto = new LoteStockResponseDTO();
        
        // Datos del Lote
        dto.setLoteId(lote.getId());
        dto.setNumeroLote(lote.getNumeroLote());
        dto.setFechaCaducidad(lote.getFechaCaducidad());
        dto.setCantidadActual(lote.getCantidadActual());
        dto.setCantidadInicial(lote.getCantidadInicial());
        
        // Datos del Producto
        if (lote.getProducto() != null) {
            dto.setProductoId(lote.getProducto().getId());
            dto.setProductoNombre(lote.getProducto().getNombre());
            dto.setSku(lote.getProducto().getSku());
        }
        
        // Datos de Ubicación (con cuidado por los nulos)
        if (lote.getContenedor() != null) {
            dto.setContenedorId(lote.getContenedor().getId());
            dto.setContenedorNombre(lote.getContenedor().getNombre());
            
            if (lote.getContenedor().getUbicacion() != null) {
                dto.setUbicacionNombre(lote.getContenedor().getUbicacion().getNombre());
            }
        }
        
        return dto;
    }



}
