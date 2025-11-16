package com.stocktrack.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("DURADERO")
public class ProductoDuradero extends Producto {
    private Integer periodoGarantia; // Ej: 12 
}
