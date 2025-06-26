package org.example.trabajoclase.service;

import org.example.trabajoclase.entity.Proveedores;
import org.example.trabajoclase.repository.ProveedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedoresService {
    
    @Autowired
    private ProveedoresRepository proveedoresRepository;
    
    public List<Proveedores> findAll() {
        return proveedoresRepository.findAll();
    }
    
    public Optional<Proveedores> findById(Integer id) {
        return proveedoresRepository.findById(id);
    }
    
    public Proveedores save(Proveedores proveedor) {
        return proveedoresRepository.save(proveedor);
    }
    
    public void deleteById(Integer id) {
        proveedoresRepository.deleteById(id);
    }
    
    public boolean existsById(Integer id) {
        return proveedoresRepository.existsById(id);
    }
    
    public Optional<Proveedores> findByRuc(String ruc) {
        return proveedoresRepository.findByRuc(ruc);
    }
}
