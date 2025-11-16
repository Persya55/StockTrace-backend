package com.stocktrack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocktrack.dto.CrearProductoRequestDTO;
import com.stocktrack.dto.ProductoDTO;
import com.stocktrack.services.ProductoService;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> getAllProductos() {
        List<ProductoDTO> productos = productoService.getAllProductos();
        return ResponseEntity.ok(productos); // Devuelve 200 OK + la lista de productos
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> getProductoById(@PathVariable Long id) {
        // @PathVariable le dice a Spring que el "{id}" de la URL
        // debe pasar a la variable "id" del método.
        

        ProductoDTO producto = productoService.getProductoById(id);
        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> crearProducto(@RequestBody CrearProductoRequestDTO requestDTO) {
    // @RequestBody le dice a Spring que convierta el JSON
    // que enviamos en el "body" a un objeto CrearProductoRequestDTO
    
    ProductoDTO productoCreado = productoService.crearProducto(requestDTO);
    return new ResponseEntity<>(productoCreado, HttpStatus.CREATED); // Devuelve 201 Created
}

@PutMapping("/{id}")
public ResponseEntity<ProductoDTO> updateProducto(@PathVariable Long id, @RequestBody CrearProductoRequestDTO requestDTO) {
    ProductoDTO productoActualizado = productoService.updateProducto(id, requestDTO);
    return ResponseEntity.ok(productoActualizado);
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
    productoService.deleteProducto(id);
    return ResponseEntity.noContent().build(); // Devuelve 204 No Content
}
}
