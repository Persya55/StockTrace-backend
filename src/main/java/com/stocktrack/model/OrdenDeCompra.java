package com.stocktrack.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime; 
import java.util.Set;


@Entity
@Table(name = "ordenes_de_compra")
@Data
@NoArgsConstructor
public class OrdenDeCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // RQF 5.3: KPI Tiempo de Solicitud (TS)
    private LocalDateTime fechaHoraSolicitudTs;

    private String estatus; // Ej: "Solicitada", "Recibida"

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = false)
    private Proveedor proveedor;

    // Una Orden de Compra tiene muchos Detalles (productos)
    @OneToMany(mappedBy = "ordenDeCompra")
    private Set<DetalleOC> detalles;
}
