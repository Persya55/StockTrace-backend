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
import java.time.LocalDateTime;

@Entity
@Table(name = "recepciones_inventario")
@Data
@NoArgsConstructor
public class RecepcionInventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // RQF 5.3: KPI Tiempo de Llegada (TL)
    private LocalDateTime fechaHoraLlegadaTl;

    // RQF 3.2: Auditoría de Discrepancias
    private Boolean discrepancia; // true o false
    private String detalleDiscrepancia; // Ej: "Llegaron 5 menos"

    @ManyToOne
    @JoinColumn(name = "orden_de_compra_id", nullable = false)
    private OrdenDeCompra ordenDeCompra;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario; // Quién recibió
}
