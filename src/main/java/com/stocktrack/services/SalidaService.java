package com.stocktrack.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktrack.dto.SugerenciaLoteDTO;
import com.stocktrack.model.LoteStock;
import com.stocktrack.repository.LoteStockRepository;


@Service
public class SalidaService {
   @Autowired
    private LoteStockRepository loteStockRepository;

    /**
     * Implementa la lógica FIFO (Primero en Caducar, Primero en Salir).
     * Devuelve la lista exacta de lotes y cantidades a retirar.
     */
    public List<SugerenciaLoteDTO> getSugerenciaFifo(Long productoId, Integer cantidadRequerida) {
        
        // 1. (RQF 4.1) Buscar todos los lotes de ese producto con stock,
        //    ordenados por la fecha de caducidad más próxima.
        //    (Este método ya lo definimos en LoteStockRepository)
        List<LoteStock> lotesDisponibles = loteStockRepository
                .findByProductoIdAndCantidadActualGreaterThanOrderByFechaCaducidadAsc(productoId, 0);

        List<SugerenciaLoteDTO> sugerencia = new ArrayList<>();
        Integer cantidadFaltante = cantidadRequerida;

        // 2. Lógica de "Cascada"
        for (LoteStock lote : lotesDisponibles) {
            if (cantidadFaltante <= 0) {
                break; // Ya completamos el pedido
            }

            // ¿Cuánto podemos tomar de este lote?
            // Tomamos el mínimo entre lo que falta y lo que el lote tiene.
            Integer cantidadARetirarDeEsteLote = Math.min(lote.getCantidadActual(), cantidadFaltante);

            // 3. Añadir a la sugerencia
            sugerencia.add(new SugerenciaLoteDTO(
                    lote.getId(),
                    lote.getNumeroLote(),
                    lote.getFechaCaducidad(),
                    lote.getCantidadActual(),
                    cantidadARetirarDeEsteLote
            ));

            // 4. Actualizar lo que nos falta
            cantidadFaltante -= cantidadARetirarDeEsteLote;
        }

        // 5. (Opcional) Advertencia si el stock no fue suficiente
        if (cantidadFaltante > 0) {
            // No podemos lanzar una excepción, porque el operario igual puede
            // querer llevarse lo que sí hay. El frontend manejará esta info.
            // Por ahora, solo devolvemos lo que pudimos cubrir.
        }

        return sugerencia;
    } 
}
