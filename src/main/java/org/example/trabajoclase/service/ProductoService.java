package org.example.trabajoclase.service;

import org.example.trabajoclase.entity.Producto;
import org.example.trabajoclase.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;
    
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }
    
    public Optional<Producto> findById(Integer id) {
        return productoRepository.findById(id);
    }
    
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }
    
    public void deleteById(Integer id) {
        productoRepository.deleteById(id);
    }
    
    public boolean existsById(Integer id) {
        return productoRepository.existsById(id);
    }
    
    public List<Producto> findByIdClasificacion(Integer idClasificacion) {
        return productoRepository.findByIdClasificacion(idClasificacion);
    }
    
    public List<Producto> findByIdProveedor(Integer idProveedor) {
        return productoRepository.findByIdProveedor(idProveedor);
    }
    
    public List<Producto> findProductosEnStock() {
        return productoRepository.findProductosEnStock();
    }
    
    public List<Producto> findByPrecioRange(Double minPrecio, Double maxPrecio) {
        return productoRepository.findByPrecioRange(minPrecio, maxPrecio);
    }
}
