package org.example.trabajoclase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    
    @Column(name = "id_persona")
    private Integer idPersona;
    
    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String user;
    
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    
    @ManyToOne
    @JoinColumn(name = "id_persona", insertable = false, updatable = false)
    private Persona persona;
    
    public boolean sexiste(String user, String password) {
        // Este método será implementado en el servicio
        return false;
    }
}
