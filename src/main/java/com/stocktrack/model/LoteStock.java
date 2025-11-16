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
import java.time.LocalDate;


@Entity
@Table(name = "lotes_stock")
@Data
@NoArgsConstructor
public class LoteStock {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // RQF 3.3: Clave para FIFO
    private LocalDate fechaCaducidad;

    private Integer cantidadInicial;
    private Integer cantidadActual;
    private String numeroLote; // Ej: "LOTE-00123"

    // --- Relaciones (FKs) ---

    // Qué producto es
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    // Dónde está (puede ser nulo si está en recepción)
    @ManyToOne
    @JoinColumn(name = "contenedor_id", nullable = true)
    private Contenedor contenedor;

    // De quién vino
    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Proveedor proveedor;

    // En qué recepción llegó (para KPI TL)
    @ManyToOne
    @JoinColumn(name = "recepcion_id", nullable = false)
    private RecepcionInventario recepcion;
}
