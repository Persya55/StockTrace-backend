package com.stocktrack.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoteStockResponseDTO {
    private Long loteId;
    private String numeroLote;
    private LocalDate fechaCaducidad;
    private Integer cantidadActual;
    private Integer cantidadInicial;
    
    // Info del Producto (Enriquecido)
    private Long productoId;
    private String productoNombre;
    private String sku;
    
    // Info de Ubicación (Enriquecido)
    private Long contenedorId; // Puede ser null
    private String contenedorNombre; // Puede ser null
    private String ubicacionNombre; // Puede ser null
}
