package org.example.trabajoclase.controller;

import org.example.trabajoclase.entity.TipoPago;
import org.example.trabajoclase.entity.Persona;
import org.example.trabajoclase.service.TipoPagoService;
import org.example.trabajoclase.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class TestController {
    
    @Autowired
    private TipoPagoService tipoPagoService;
    
    @Autowired
    private PersonaService personaService;
    
    @GetMapping("/datos")
    public Map<String, Object> verificarDatos() {
        Map<String, Object> resultado = new HashMap<>();
        
        List<TipoPago> tiposPago = tipoPagoService.findAll();
        List<Persona> personas = personaService.findAll();
        
        resultado.put("totalTiposPago", tiposPago.size());
        resultado.put("tiposPago", tiposPago);
        resultado.put("totalPersonas", personas.size());
        resultado.put("personas", personas);
        
        return resultado;
    }
}
