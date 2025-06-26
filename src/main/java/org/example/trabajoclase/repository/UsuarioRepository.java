package org.example.trabajoclase.repository;

import org.example.trabajoclase.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    Optional<Usuario> findByUserAndPassword(String user, String password);
    
    Optional<Usuario> findByUser(String user);
}
