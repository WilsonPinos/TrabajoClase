package org.example.trabajoclase.controller;

import org.example.trabajoclase.entity.ItemFactura;
import org.example.trabajoclase.service.ItemFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items-factura")
@Tag(name = "ItemFactura", description = "API para gestión de items de factura")
public class ItemFacturaController {
    
    @Autowired
    private ItemFacturaService itemFacturaService;
    
    @GetMapping
    @Operation(summary = "Obtener todos los items de factura")
    public ResponseEntity<List<ItemFactura>> getAllItemsFactura() {
        List<ItemFactura> items = itemFacturaService.findAll();
        return ResponseEntity.ok(items);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Obtener item de factura por ID")
    public ResponseEntity<ItemFactura> getItemFacturaById(@PathVariable Integer id) {
        Optional<ItemFactura> item = itemFacturaService.findById(id);
        return item.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    @Operation(summary = "Crear nuevo item de factura")
    public ResponseEntity<ItemFactura> createItemFactura(@RequestBody ItemFactura itemFactura) {
        try {
            ItemFactura savedItem = itemFacturaService.save(itemFactura);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar item de factura")
    public ResponseEntity<ItemFactura> updateItemFactura(@PathVariable Integer id, @RequestBody ItemFactura itemFactura) {
        if (!itemFacturaService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        itemFactura.setIdItemFactura(id);
        ItemFactura updatedItem = itemFacturaService.save(itemFactura);
        return ResponseEntity.ok(updatedItem);
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar item de factura")
    public ResponseEntity<Void> deleteItemFactura(@PathVariable Integer id) {
        if (!itemFacturaService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        itemFacturaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/factura/{idFactura}")
    @Operation(summary = "Obtener items por ID de factura")
    public ResponseEntity<List<ItemFactura>> getItemsByFactura(@PathVariable Integer idFactura) {
        List<ItemFactura> items = itemFacturaService.findByIdFactura(idFactura);
        return ResponseEntity.ok(items);
    }
    
    @GetMapping("/producto/{idProducto}")
    @Operation(summary = "Obtener items por ID de producto")
    public ResponseEntity<List<ItemFactura>> getItemsByProducto(@PathVariable Integer idProducto) {
        List<ItemFactura> items = itemFacturaService.findByIdProducto(idProducto);
        return ResponseEntity.ok(items);
    }
}
