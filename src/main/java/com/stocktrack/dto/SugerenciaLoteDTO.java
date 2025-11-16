package com.stocktrack.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SugerenciaLoteDTO {
    private Long loteId;
    private String numeroLote;
    private LocalDate fechaCaducidad;
    private Integer cantidadDisponibleEnLote;
    
    // Esta es la cantidad que el operario debe tomar de ESTE lote
    private Integer cantidadARetirar;
}
