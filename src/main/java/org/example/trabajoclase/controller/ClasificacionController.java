package org.example.trabajoclase.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.trabajoclase.entity.Clasificacion;
import org.example.trabajoclase.service.ClasificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clasificaciones")
@Tag(name = "Clasificaciones", description = "API para gestión de clasificaciones")
public class ClasificacionController {
    
    @Autowired
    private ClasificacionService clasificacionService;
    
    @GetMapping
    @Operation(summary = "Obtener todas las clasificaciones")
    public ResponseEntity<List<Clasificacion>> getAllClasificaciones() {
        List<Clasificacion> clasificaciones = clasificacionService.findAll();
        return ResponseEntity.ok(clasificaciones);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Obtener clasificación por ID")
    public ResponseEntity<Clasificacion> getClasificacionById(@PathVariable Integer id) {
        Optional<Clasificacion> clasificacion = clasificacionService.findById(id);
        return clasificacion.map(ResponseEntity::ok)
                           .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    @Operation(summary = "Crear nueva clasificación")
    public ResponseEntity<Clasificacion> createClasificacion(@RequestBody Clasificacion clasificacion) {
        Clasificacion savedClasificacion = clasificacionService.save(clasificacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClasificacion);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar clasificación")
    public ResponseEntity<Clasificacion> updateClasificacion(@PathVariable Integer id, @RequestBody Clasificacion clasificacion) {
        if (!clasificacionService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        clasificacion.setIdClasificacion(id);
        Clasificacion updatedClasificacion = clasificacionService.save(clasificacion);
        return ResponseEntity.ok(updatedClasificacion);
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar clasificación")
    public ResponseEntity<Void> deleteClasificacion(@PathVariable Integer id) {
        if (!clasificacionService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        clasificacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
