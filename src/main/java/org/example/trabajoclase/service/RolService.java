package org.example.trabajoclase.service;

import org.example.trabajoclase.entity.Rol;
import org.example.trabajoclase.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {
    
    @Autowired
    private RolRepository rolRepository;
    
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }
    
    public Optional<Rol> findById(Integer id) {
        return rolRepository.findById(id);
    }
    
    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }
    
    public void deleteById(Integer id) {
        rolRepository.deleteById(id);
    }
    
    public boolean existsById(Integer id) {
        return rolRepository.existsById(id);
    }
    
    public boolean sexisteRol(String rol) {
        return rolRepository.findByRol(rol).isPresent();
    }
    
    public boolean estado(String rol) {
        Optional<Rol> rolEntity = rolRepository.findByRol(rol);
        return rolEntity.map(Rol::getEstado).orElse(false);
    }
}
