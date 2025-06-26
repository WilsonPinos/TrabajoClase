package org.example.trabajoclase.repository;

import org.example.trabajoclase.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
    List<Producto> findByIdClasificacion(Integer idClasificacion);
    
    List<Producto> findByIdProveedor(Integer idProveedor);
    
    @Query("SELECT p FROM Producto p WHERE p.stock > 0")
    List<Producto> findProductosEnStock();
    
    @Query("SELECT p FROM Producto p WHERE p.precioUnitario BETWEEN :minPrecio AND :maxPrecio")
    List<Producto> findByPrecioRange(@Param("minPrecio") Double minPrecio, @Param("maxPrecio") Double maxPrecio);
}
