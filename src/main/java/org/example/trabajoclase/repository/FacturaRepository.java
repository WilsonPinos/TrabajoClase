package org.example.trabajoclase.repository;

import org.example.trabajoclase.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    
    List<Factura> findByIdPersona(Integer idPersona);
    
    List<Factura> findByRuc(String ruc);
    
    @Query("SELECT f FROM Factura f WHERE f.fecha BETWEEN :fechaInicio AND :fechaFin")
    List<Factura> findByFechaRange(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);
    
    @Query("SELECT SUM(f.total) FROM Factura f WHERE f.fecha BETWEEN :fechaInicio AND :fechaFin")
    Double findTotalVentasByFechaRange(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);
}
