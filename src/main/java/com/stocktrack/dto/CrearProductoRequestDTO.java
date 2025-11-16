package com.stocktrack.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CrearProductoRequestDTO {
// Campos comunes
    private String nombre;
    private String sku;
    private BigDecimal largo;
    private BigDecimal ancho;
    private BigDecimal volumen;
    
    // Campo discriminador
    private String tipoProducto; // "COMESTIBLE" o "DURADERO"
    
    // Campos específicos
    private Integer tiempoVidaUtilBase; // (Solo para Comestible)
    private Integer periodoGarantia;    
}
