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
@Table(name = "detalles_oc")
@Data
@NoArgsConstructor
public class DetalleOC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cantidadSolicitada;

    // Relación con la Orden de Compra
    @ManyToOne
    @JoinColumn(name = "orden_de_compra_id", nullable = false)
    private OrdenDeCompra ordenDeCompra;

    // Relación con el Producto
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;
}
