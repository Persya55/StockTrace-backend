package com.stocktrack.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductoDTO {
    
    private Long id;
    
    private String nombre;
    private String sku;
    private BigDecimal largo;
    private BigDecimal ancho;
    private BigDecimal volumen;
    
    // Importante para la herencia:
    private String tipoProducto; // "Comestible" o "Duradero"
    private Integer tiempoVidaUtilBase;
    private Integer periodoGarantia;

}
