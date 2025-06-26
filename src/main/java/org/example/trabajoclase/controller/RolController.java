package org.example.trabajoclase.controller;

import org.example.trabajoclase.entity.Rol;
import org.example.trabajoclase.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
@Tag(name = "Rol", description = "API para gestión de roles")
public class RolController {
    
    @Autowired
    private RolService rolService;
    
    @GetMapping
    @Operation(summary = "Obtener todos los roles")
    public ResponseEntity<List<Rol>> getAllRoles() {
        List<Rol> roles = rolService.findAll();
        return ResponseEntity.ok(roles);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Obtener rol por ID")
    public ResponseEntity<Rol> getRolById(@PathVariable Integer id) {
        Optional<Rol> rol = rolService.findById(id);
        return rol.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    @Operation(summary = "Crear nuevo rol")
    public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
        try {
            Rol savedRol = rolService.save(rol);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedRol);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar rol")
    public ResponseEntity<Rol> updateRol(@PathVariable Integer id, @RequestBody Rol rol) {
        if (!rolService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        rol.setIdRol(id);
        Rol updatedRol = rolService.save(rol);
        return ResponseEntity.ok(updatedRol);
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar rol")
    public ResponseEntity<Void> deleteRol(@PathVariable Integer id) {
        if (!rolService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        rolService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/existe/{rol}")
    @Operation(summary = "Verificar si existe rol")
    public ResponseEntity<Boolean> existeRol(@PathVariable String rol) {
        boolean exists = rolService.sexisteRol(rol);
        return ResponseEntity.ok(exists);
    }
    
    @GetMapping("/estado/{rol}")
    @Operation(summary = "Obtener estado del rol")
    public ResponseEntity<Boolean> estadoRol(@PathVariable String rol) {
        boolean estado = rolService.estado(rol);
        return ResponseEntity.ok(estado);
    }
}
