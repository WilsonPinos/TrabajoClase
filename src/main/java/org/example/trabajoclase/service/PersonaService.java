package org.example.trabajoclase.service;

import org.example.trabajoclase.entity.Persona;
import org.example.trabajoclase.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    
    @Autowired
    private PersonaRepository personaRepository;
    
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }
    
    public Optional<Persona> findById(Integer id) {
        return personaRepository.findById(id);
    }
    
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }
    
    public void deleteById(Integer id) {
        personaRepository.deleteById(id);
    }
    
    public boolean existsById(Integer id) {
        return personaRepository.existsById(id);
    }
    
    public Optional<Persona> findByDni(String dni) {
        return personaRepository.findByDni(dni);
    }
    
    public String findNombreCompletoByDni(String dni) {
        return personaRepository.findNombreCompletoByDni(dni);
    }
}
