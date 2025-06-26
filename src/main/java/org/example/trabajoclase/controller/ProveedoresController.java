package org.example.trabajoclase.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.trabajoclase.entity.Proveedores;
import org.example.trabajoclase.service.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proveedores")
@Tag(name = "Proveedores", description = "API para gestión de proveedores")
public class ProveedoresController {
    
    @Autowired
    private ProveedoresService proveedoresService;
    
    @GetMapping
    @Operation(summary = "Obtener todos los proveedores")
    public ResponseEntity<List<Proveedores>> getAllProveedores() {
        List<Proveedores> proveedores = proveedoresService.findAll();
        return ResponseEntity.ok(proveedores);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Obtener proveedor por ID")
    public ResponseEntity<Proveedores> getProveedorById(@PathVariable Integer id) {
        Optional<Proveedores> proveedor = proveedoresService.findById(id);
        return proveedor.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/ruc/{ruc}")
    @Operation(summary = "Obtener proveedor por RUC")
    public ResponseEntity<Proveedores> getProveedorByRuc(@PathVariable String ruc) {
        Optional<Proveedores> proveedor = proveedoresService.findByRuc(ruc);
        return proveedor.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    @Operation(summary = "Crear nuevo proveedor")
    public ResponseEntity<Proveedores> createProveedor(@RequestBody Proveedores proveedor) {
        Proveedores savedProveedor = proveedoresService.save(proveedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProveedor);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar proveedor")
    public ResponseEntity<Proveedores> updateProveedor(@PathVariable Integer id, @RequestBody Proveedores proveedor) {
        if (!proveedoresService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        proveedor.setIdProveedor(id);
        Proveedores updatedProveedor = proveedoresService.save(proveedor);
        return ResponseEntity.ok(updatedProveedor);
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar proveedor")
    public ResponseEntity<Void> deleteProveedor(@PathVariable Integer id) {
        if (!proveedoresService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        proveedoresService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
