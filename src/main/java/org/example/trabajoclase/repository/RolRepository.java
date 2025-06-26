package org.example.trabajoclase.repository;

import org.example.trabajoclase.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    
    Optional<Rol> findByRol(String rol);
    
    Optional<Rol> findByRolAndEstado(String rol, Boolean estado);
}
