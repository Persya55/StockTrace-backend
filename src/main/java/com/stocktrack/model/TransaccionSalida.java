package com.stocktrack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.Set;


@Entity
@Table(name = "transacciones_salida")
@Data
@NoArgsConstructor
public class TransaccionSalida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaHoraSalida;

    // RQF 4.1: Motivo de la salida
    private String motivo; // "Venta", "Perdida", "Consumo"

    // RQF 4.2: Precio (si fue venta)
    private BigDecimal precioDeVenta;

    // Una transacción tiene muchos detalles (lotes)
    @OneToMany(mappedBy = "transaccionSalida")
    private Set<DetalleSalida> detalles;
}
