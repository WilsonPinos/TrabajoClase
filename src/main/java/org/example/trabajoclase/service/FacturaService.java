package org.example.trabajoclase.service;

import org.example.trabajoclase.entity.Factura;
import org.example.trabajoclase.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {
    
    @Autowired
    private FacturaRepository facturaRepository;
    
    public List<Factura> findAll() {
        return facturaRepository.findAll();
    }
    
    public Optional<Factura> findById(Integer id) {
        return facturaRepository.findById(id);
    }
    
    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }
    
    public void deleteById(Integer id) {
        facturaRepository.deleteById(id);
    }
    
    public boolean existsById(Integer id) {
        return facturaRepository.existsById(id);
    }
    
    public List<Factura> findByIdPersona(Integer idPersona) {
        return facturaRepository.findByIdPersona(idPersona);
    }
    
    public List<Factura> findByRuc(String ruc) {
        return facturaRepository.findByRuc(ruc);
    }
    
    public List<Factura> findByFechaRange(Date fechaInicio, Date fechaFin) {
        return facturaRepository.findByFechaRange(fechaInicio, fechaFin);
    }
    
    public Double findTotalVentasByFechaRange(Date fechaInicio, Date fechaFin) {
        return facturaRepository.findTotalVentasByFechaRange(fechaInicio, fechaFin);
    }
}
