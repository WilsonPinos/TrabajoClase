package org.example.trabajoclase.controller;

import org.example.trabajoclase.entity.Competencia;
import org.example.trabajoclase.service.CompetenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/competencias")
@Tag(name = "Competencia", description = "API para gestión de competencias")
public class CompetenciaController {
    
    @Autowired
    private CompetenciaService competenciaService;
    
    @GetMapping
    @Operation(summary = "Obtener todas las competencias")
    public ResponseEntity<List<Competencia>> getAllCompetencias() {
        List<Competencia> competencias = competenciaService.findAll();
        return ResponseEntity.ok(competencias);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Obtener competencia por ID")
    public ResponseEntity<Competencia> getCompetenciaById(@PathVariable Integer id) {
        Optional<Competencia> competencia = competenciaService.findById(id);
        return competencia.map(ResponseEntity::ok)
                         .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    @Operation(summary = "Crear nueva competencia")
    public ResponseEntity<Competencia> createCompetencia(@RequestBody Competencia competencia) {
        try {
            Competencia savedCompetencia = competenciaService.save(competencia);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCompetencia);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar competencia")
    public ResponseEntity<Competencia> updateCompetencia(@PathVariable Integer id, @RequestBody Competencia competencia) {
        if (!competenciaService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        competencia.setIdCompetencias(id);
        Competencia updatedCompetencia = competenciaService.save(competencia);
        return ResponseEntity.ok(updatedCompetencia);
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar competencia")
    public ResponseEntity<Void> deleteCompetencia(@PathVariable Integer id) {
        if (!competenciaService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        competenciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/existe/{nombre}")
    @Operation(summary = "Verificar si existe competencia")
    public ResponseEntity<Boolean> existeCompetencia(@PathVariable String nombre) {
        boolean exists = competenciaService.sexisteComp(nombre);
        return ResponseEntity.ok(exists);
    }
}
