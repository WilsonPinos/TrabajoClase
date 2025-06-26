package org.example.trabajoclase.service;

import org.example.trabajoclase.entity.Clasificacion;
import org.example.trabajoclase.repository.ClasificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasificacionService {
    
    @Autowired
    private ClasificacionRepository clasificacionRepository;
    
    public List<Clasificacion> findAll() {
        return clasificacionRepository.findAll();
    }
    
    public Optional<Clasificacion> findById(Integer id) {
        return clasificacionRepository.findById(id);
    }
    
    public Clasificacion save(Clasificacion clasificacion) {
        return clasificacionRepository.save(clasificacion);
    }
    
    public void deleteById(Integer id) {
        clasificacionRepository.deleteById(id);
    }
    
    public boolean existsById(Integer id) {
        return clasificacionRepository.existsById(id);
    }
}
