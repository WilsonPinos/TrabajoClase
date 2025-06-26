package org.example.trabajoclase.repository;

import org.example.trabajoclase.entity.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedores, Integer> {
    
    Optional<Proveedores> findByRuc(String ruc);
}
