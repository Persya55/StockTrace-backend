package com.stocktrack.services;

import com.stocktrack.dto.ProductoDTO;
import com.stocktrack.model.Producto;
import com.stocktrack.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocktrack.model.ProductoComestible;
import com.stocktrack.model.ProductoDuradero;
import com.stocktrack.dto.CrearProductoRequestDTO;


import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductoService {
    // Inyectamos el repositorio que creaste
    @Autowired
    private ProductoRepository productoRepository;

    // Método para obtener TODOS los productos
    public List<ProductoDTO> getAllProductos() {
        // 1. Llama a la BD
        List<Producto> productos = productoRepository.findAll();
        
        // 2. Convierte la Entidad (Producto) a DTO (ProductoDTO)
        return productos.stream()
                .map(this::convertirAProductoDTO)
                .collect(Collectors.toList());
    }

    // Método para obtener UN producto por ID
    public ProductoDTO getProductoById(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return convertirAProductoDTO(producto);
    }

    // --- Métodos de conversión privados ---
    
    // Un método simple para "mapear" de la entidad al DTO
    private ProductoDTO convertirAProductoDTO(Producto producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setSku(producto.getSku());
        dto.setLargo(producto.getLargo());
        dto.setAncho(producto.getAncho());
        dto.setVolumen(producto.getVolumen());
        
        // Aquí detectamos el tipo (lógica de herencia)
        // Usamos una sintaxis moderna de Java (pattern matching)
        if (producto instanceof ProductoComestible comestible) {
        dto.setTipoProducto("COMESTIBLE");
        dto.setTiempoVidaUtilBase(comestible.getTiempoVidaUtilBase());
        } 
        else if (producto instanceof ProductoDuradero duradero) {
        dto.setTipoProducto("DURADERO");
        dto.setPeriodoGarantia(duradero.getPeriodoGarantia());
        }
        
        return dto;
    }


    public ProductoDTO crearProducto(CrearProductoRequestDTO dto) {
    Producto nuevoProducto;

    // 1. Decidir qué tipo de producto crear
    if ("COMESTIBLE".equalsIgnoreCase(dto.getTipoProducto())) {
        ProductoComestible p = new ProductoComestible();
        p.setTiempoVidaUtilBase(dto.getTiempoVidaUtilBase());
        nuevoProducto = p;
    } else if ("DURADERO".equalsIgnoreCase(dto.getTipoProducto())) {
        ProductoDuradero p = new ProductoDuradero();
        p.setPeriodoGarantia(dto.getPeriodoGarantia());
        nuevoProducto = p;
    } else {
        throw new IllegalArgumentException("Tipo de producto no válido: " + dto.getTipoProducto());
    }

    // 2. Setear los atributos comunes
    nuevoProducto.setNombre(dto.getNombre());
    nuevoProducto.setSku(dto.getSku());
    nuevoProducto.setLargo(dto.getLargo());
    nuevoProducto.setAncho(dto.getAncho());
    nuevoProducto.setVolumen(dto.getVolumen());

    // 3. Guardar en la BD
    Producto productoGuardado = productoRepository.save(nuevoProducto);

    // 4. Convertir a DTO para la respuesta
    return convertirAProductoDTO(productoGuardado);
}

    public ProductoDTO updateProducto(Long id, CrearProductoRequestDTO dto) {
    // 1. Buscar el producto existente
    Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));

    // 2. Actualizar los campos comunes
    producto.setNombre(dto.getNombre());
    producto.setSku(dto.getSku());
    producto.setLargo(dto.getLargo());
    producto.setAncho(dto.getAncho());
    producto.setVolumen(dto.getVolumen());

    // 3. Actualizar campos específicos (con lógica de herencia)
    if (producto instanceof ProductoComestible comestible && "COMESTIBLE".equalsIgnoreCase(dto.getTipoProducto())) {
        comestible.setTiempoVidaUtilBase(dto.getTiempoVidaUtilBase());
    } else if (producto instanceof ProductoDuradero duradero && "DURADERO".equalsIgnoreCase(dto.getTipoProducto())) {
        duradero.setPeriodoGarantia(dto.getPeriodoGarantia());
    }
    // (Nota: No permitimos cambiar el *tipo* de producto, ej: de Comestible a Duradero)

    // 4. Guardar los cambios
    Producto productoActualizado = productoRepository.save(producto);

    // 5. Devolver el DTO
    return convertirAProductoDTO(productoActualizado);
}

public void deleteProducto(Long id) {
    // 1. Verificar si existe
    if (!productoRepository.existsById(id)) {
        throw new RuntimeException("Producto no encontrado con id: " + id);
    }
    // 2. Eliminar
    productoRepository.deleteById(id);

}
}