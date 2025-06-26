package org.example.trabajoclase.repository;

import org.example.trabajoclase.entity.ItemFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemFacturaRepository extends JpaRepository<ItemFactura, Integer> {
    
    List<ItemFactura> findByIdFactura(Integer idFactura);
    
    List<ItemFactura> findByIdProducto(Integer idProducto);
}
