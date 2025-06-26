package org.example.trabajoclase.service;

import org.example.trabajoclase.entity.TipoPago;
import org.example.trabajoclase.repository.TipoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoPagoService {
    
    @Autowired
    private TipoPagoRepository tipoPagoRepository;
    
    public List<TipoPago> findAll() {
        return tipoPagoRepository.findAll();
    }
    
    public Optional<TipoPago> findById(Integer id) {
        return tipoPagoRepository.findById(id);
    }
    
    public TipoPago save(TipoPago tipoPago) {
        return tipoPagoRepository.save(tipoPago);
    }
    
    public void deleteById(Integer id) {
        tipoPagoRepository.deleteById(id);
    }
    
    public boolean existsById(Integer id) {
        return tipoPagoRepository.existsById(id);
    }
}
