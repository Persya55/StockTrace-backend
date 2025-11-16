package com.stocktrack.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set; 
@Entity
@Table(name = "ubicaciones")
@Data
@NoArgsConstructor
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre; // Ej: "Almacén Principal", "Zona Fría"
    private String tipoUbicacion; // Ej: "MainAlmacen", "Recepcion"

    // Una Ubicación (Almacén) tiene muchos Contenedores (Estantes)
    @OneToMany(mappedBy = "ubicacion")
    private Set<Contenedor> contenedores;
}
