package com.stocktrack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detalles_salida")
@Data
@NoArgsConstructor
public class DetalleSalida {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cantidadRetirada;

    // A qué transacción pertenece
    @ManyToOne
    @JoinColumn(name = "transaccion_salida_id", nullable = false)
    private TransaccionSalida transaccionSalida;

    // RQF 4.1: Qué lote exacto se consumió
    @ManyToOne
    @JoinColumn(name = "lote_id", nullable = false)
    private LoteStock loteStock;

}
