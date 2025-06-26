package org.example.trabajoclase.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.trabajoclase.entity.Persona;
import org.example.trabajoclase.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personas")
@Tag(name = "Personas", description = "API para gestión de personas")
public class PersonaController {
    
    @Autowired
    private PersonaService personaService;
    
    @GetMapping
    @Operation(summary = "Obtener todas las personas")
    public ResponseEntity<List<Persona>> getAllPersonas() {
        List<Persona> personas = personaService.findAll();
        return ResponseEntity.ok(personas);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Obtener persona por ID")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Integer id) {
        Optional<Persona> persona = personaService.findById(id);
        return persona.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/dni/{dni}")
    @Operation(summary = "Obtener persona por DNI")
    public ResponseEntity<Persona> getPersonaByDni(@PathVariable String dni) {
        Optional<Persona> persona = personaService.findByDni(dni);
        return persona.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/nombre-completo/{dni}")
    @Operation(summary = "Obtener nombre completo por DNI")
    public ResponseEntity<String> getNombreCompletoByDni(@PathVariable String dni) {
        String nombreCompleto = personaService.findNombreCompletoByDni(dni);
        if (nombreCompleto != null) {
            return ResponseEntity.ok(nombreCompleto);
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping
    @Operation(summary = "Crear nueva persona")
    public ResponseEntity<Persona> createPersona(@RequestBody Persona persona) {
        Persona savedPersona = personaService.save(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPersona);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar persona")
    public ResponseEntity<Persona> updatePersona(@PathVariable Integer id, @RequestBody Persona persona) {
        if (!personaService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        persona.setIdPersona(id);
        Persona updatedPersona = personaService.save(persona);
        return ResponseEntity.ok(updatedPersona);
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar persona")
    public ResponseEntity<Void> deletePersona(@PathVariable Integer id) {
        if (!personaService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        personaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
