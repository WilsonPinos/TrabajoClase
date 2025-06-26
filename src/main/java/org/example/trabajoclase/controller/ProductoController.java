package org.example.trabajoclase.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.trabajoclase.entity.Producto;
import org.example.trabajoclase.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "Productos", description = "API para gestión de productos")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping
    @Operation(summary = "Obtener todos los productos")
    public ResponseEntity<List<Producto>> getAllProductos() {
        List<Producto> productos = productoService.findAll();
        return ResponseEntity.ok(productos);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Obtener producto por ID")
    public ResponseEntity<Producto> getProductoById(@PathVariable Integer id) {
        Optional<Producto> producto = productoService.findById(id);
        return producto.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/clasificacion/{idClasificacion}")
    @Operation(summary = "Obtener productos por clasificación")
    public ResponseEntity<List<Producto>> getProductosByClasificacion(@PathVariable Integer idClasificacion) {
        List<Producto> productos = productoService.findByIdClasificacion(idClasificacion);
        return ResponseEntity.ok(productos);
    }
    
    @GetMapping("/proveedor/{idProveedor}")
    @Operation(summary = "Obtener productos por proveedor")
    public ResponseEntity<List<Producto>> getProductosByProveedor(@PathVariable Integer idProveedor) {
        List<Producto> productos = productoService.findByIdProveedor(idProveedor);
        return ResponseEntity.ok(productos);
    }
    
    @GetMapping("/en-stock")
    @Operation(summary = "Obtener productos en stock")
    public ResponseEntity<List<Producto>> getProductosEnStock() {
        List<Producto> productos = productoService.findProductosEnStock();
        return ResponseEntity.ok(productos);
    }
    
    @GetMapping("/precio-rango")
    @Operation(summary = "Obtener productos por rango de precio")
    public ResponseEntity<List<Producto>> getProductosByPrecioRange(
            @RequestParam Double minPrecio, 
            @RequestParam Double maxPrecio) {
        List<Producto> productos = productoService.findByPrecioRange(minPrecio, maxPrecio);
        return ResponseEntity.ok(productos);
    }
    
    @PostMapping
    @Operation(summary = "Crear nuevo producto")
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        Producto savedProducto = productoService.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProducto);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar producto")
    public ResponseEntity<Producto> updateProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        if (!productoService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        producto.setIdProducto(id);
        Producto updatedProducto = productoService.save(producto);
        return ResponseEntity.ok(updatedProducto);
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar producto")
    public ResponseEntity<Void> deleteProducto(@PathVariable Integer id) {
        if (!productoService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        productoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
