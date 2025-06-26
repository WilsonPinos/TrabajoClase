package org.example.trabajoclase.service;

import org.example.trabajoclase.entity.Competencia;
import org.example.trabajoclase.repository.CompetenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetenciaService {
    
    @Autowired
    private CompetenciaRepository competenciaRepository;
    
    public List<Competencia> findAll() {
        return competenciaRepository.findAll();
    }
    
    public Optional<Competencia> findById(Integer id) {
        return competenciaRepository.findById(id);
    }
    
    public Competencia save(Competencia competencia) {
        return competenciaRepository.save(competencia);
    }
    
    public void deleteById(Integer id) {
        competenciaRepository.deleteById(id);
    }
    
    public boolean existsById(Integer id) {
        return competenciaRepository.existsById(id);
    }
    
    public boolean sexisteComp(String nombre) {
        return competenciaRepository.findByNombre(nombre).isPresent();
    }
}
