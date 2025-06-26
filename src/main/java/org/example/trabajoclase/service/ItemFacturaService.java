package org.example.trabajoclase.service;

import org.example.trabajoclase.entity.ItemFactura;
import org.example.trabajoclase.repository.ItemFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemFacturaService {
    
    @Autowired
    private ItemFacturaRepository itemFacturaRepository;
    
    public List<ItemFactura> findAll() {
        return itemFacturaRepository.findAll();
    }
    
    public Optional<ItemFactura> findById(Integer id) {
        return itemFacturaRepository.findById(id);
    }
    
    public ItemFactura save(ItemFactura itemFactura) {
        // Calcular subtotal automáticamente
        if (itemFactura.getCantidad() != null && itemFactura.getPrecio() != null) {
            itemFactura.setSubtotal(itemFactura.getCantidad() * itemFactura.getPrecio());
        }
        return itemFacturaRepository.save(itemFactura);
    }
    
    public void deleteById(Integer id) {
        itemFacturaRepository.deleteById(id);
    }
    
    public boolean existsById(Integer id) {
        return itemFacturaRepository.existsById(id);
    }
    
    public List<ItemFactura> findByIdFactura(Integer idFactura) {
        return itemFacturaRepository.findByIdFactura(idFactura);
    }
    
    public List<ItemFactura> findByIdProducto(Integer idProducto) {
        return itemFacturaRepository.findByIdProducto(idProducto);
    }
}
