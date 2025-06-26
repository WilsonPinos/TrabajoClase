package org.example.trabajoclase.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.trabajoclase.entity.TipoPago;
import org.example.trabajoclase.service.TipoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipos-pago")
@Tag(name = "Tipos de Pago", description = "API para gestión de tipos de pago")
public class TipoPagoController {
    
    @Autowired
    private TipoPagoService tipoPagoService;
    
    @GetMapping
    @Operation(summary = "Obtener todos los tipos de pago")
    public ResponseEntity<List<TipoPago>> getAllTiposPago() {
        List<TipoPago> tiposPago = tipoPagoService.findAll();
        return ResponseEntity.ok(tiposPago);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Obtener tipo de pago por ID")
    public ResponseEntity<TipoPago> getTipoPagoById(@PathVariable Integer id) {
        Optional<TipoPago> tipoPago = tipoPagoService.findById(id);
        return tipoPago.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    @Operation(summary = "Crear nuevo tipo de pago")
    public ResponseEntity<TipoPago> createTipoPago(@RequestBody TipoPago tipoPago) {
        TipoPago savedTipoPago = tipoPagoService.save(tipoPago);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTipoPago);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar tipo de pago")
    public ResponseEntity<TipoPago> updateTipoPago(@PathVariable Integer id, @RequestBody TipoPago tipoPago) {
        if (!tipoPagoService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tipoPago.setIdTipoPago(id);
        TipoPago updatedTipoPago = tipoPagoService.save(tipoPago);
        return ResponseEntity.ok(updatedTipoPago);
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar tipo de pago")
    public ResponseEntity<Void> deleteTipoPago(@PathVariable Integer id) {
        if (!tipoPagoService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tipoPagoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
