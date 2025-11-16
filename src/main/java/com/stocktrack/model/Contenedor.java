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
@Table(name = "contenedores")
@Data
@NoArgsConstructor
public class Contenedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // RQF 2.3: El QR identifica al contenedor
    private String codigoQrId; 

    private String nombre; // Ej: "Estante A-1-C4"
    private String estatus; // Ej: "Vacio", "Ocupado"

    // Un Contenedor (Estante) pertenece a una Ubicación (Almacén)
    @ManyToOne
    @JoinColumn(name = "ubicacion_id", nullable = false)
    private Ubicacion ubicacion;
}
