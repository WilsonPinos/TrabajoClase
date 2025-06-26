package org.example.trabajoclase.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.trabajoclase.entity.Factura;
import org.example.trabajoclase.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/facturas")
@Tag(name = "Facturas", description = "API para gestión de facturas")
public class FacturaController {
    
    @Autowired
    private FacturaService facturaService;
    
    @GetMapping
    @Operation(summary = "Obtener todas las facturas")
    public ResponseEntity<List<Factura>> getAllFacturas() {
        List<Factura> facturas = facturaService.findAll();
        return ResponseEntity.ok(facturas);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Obtener factura por ID")
    public ResponseEntity<Factura> getFacturaById(@PathVariable Integer id) {
        Optional<Factura> factura = facturaService.findById(id);
        return factura.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/persona/{idPersona}")
    @Operation(summary = "Obtener facturas por persona")
    public ResponseEntity<List<Factura>> getFacturasByPersona(@PathVariable Integer idPersona) {
        List<Factura> facturas = facturaService.findByIdPersona(idPersona);
        return ResponseEntity.ok(facturas);
    }
    
    @GetMapping("/ruc/{ruc}")
    @Operation(summary = "Obtener facturas por RUC")
    public ResponseEntity<List<Factura>> getFacturasByRuc(@PathVariable String ruc) {
        List<Factura> facturas = facturaService.findByRuc(ruc);
        return ResponseEntity.ok(facturas);
    }
    
    @GetMapping("/fecha-rango")
    @Operation(summary = "Obtener facturas por rango de fechas")
    public ResponseEntity<List<Factura>> getFacturasByFechaRange(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {
        List<Factura> facturas = facturaService.findByFechaRange(fechaInicio, fechaFin);
        return ResponseEntity.ok(facturas);
    }
    
    @GetMapping("/total-ventas")
    @Operation(summary = "Obtener total de ventas por rango de fechas")
    public ResponseEntity<Double> getTotalVentasByFechaRange(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {
        Double totalVentas = facturaService.findTotalVentasByFechaRange(fechaInicio, fechaFin);
        return ResponseEntity.ok(totalVentas != null ? totalVentas : 0.0);
    }
    
    @PostMapping
    @Operation(summary = "Crear nueva factura")
    public ResponseEntity<Factura> createFactura(@RequestBody Factura factura) {
        Factura savedFactura = facturaService.save(factura);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFactura);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar factura")
    public ResponseEntity<Factura> updateFactura(@PathVariable Integer id, @RequestBody Factura factura) {
        if (!facturaService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        factura.setIdFactura(id);
        Factura updatedFactura = facturaService.save(factura);
        return ResponseEntity.ok(updatedFactura);
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar factura")
    public ResponseEntity<Void> deleteFactura(@PathVariable Integer id) {
        if (!facturaService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        facturaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
