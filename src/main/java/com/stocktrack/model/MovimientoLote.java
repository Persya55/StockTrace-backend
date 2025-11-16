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
@Table(name = "movimientos_lote")
@Data
@NoArgsConstructor
public class MovimientoLote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // RQF 5.3: KPI Tiempo de Organización (TO)
    private LocalDateTime fechaHoraOrganizacionTo;

    // Qué lote se movió
    @ManyToOne
    @JoinColumn(name = "lote_id", nullable = false)
    private LoteStock loteStock;

    // Quién lo movió
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
