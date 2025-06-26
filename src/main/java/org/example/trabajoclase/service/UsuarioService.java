package org.example.trabajoclase.service;

import org.example.trabajoclase.entity.Usuario;
import org.example.trabajoclase.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
    
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }
    
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }
    
    public boolean existsById(Integer id) {
        return usuarioRepository.existsById(id);
    }
    
    public boolean sexiste(String user, String password) {
        return usuarioRepository.findByUserAndPassword(user, password).isPresent();
    }
    
    public Optional<Usuario> findByUser(String user) {
        return usuarioRepository.findByUser(user);
    }
}
