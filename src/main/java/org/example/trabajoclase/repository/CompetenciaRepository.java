package org.example.trabajoclase.repository;

import org.example.trabajoclase.entity.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, Integer> {
    
    Optional<Competencia> findByNombre(String nombre);
}
