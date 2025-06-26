package org.example.trabajoclase.repository;

import org.example.trabajoclase.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    
    Optional<Persona> findByDni(String dni);
    
    @Query("SELECT CONCAT(p.nombre, ' ', p.apellido) FROM Persona p WHERE p.dni = :dni")
    String findNombreCompletoByDni(@Param("dni") String dni);
}
