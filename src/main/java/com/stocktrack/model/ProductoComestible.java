package com.stocktrack.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) // Importante para la herencia con Lombok
@DiscriminatorValue("COMESTIBLE") // Identificador para la tabla
public class ProductoComestible extends Producto {
    
    private Integer tiempoVidaUtilBase; 

}
