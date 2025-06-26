package org.example.trabajoclase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "persona")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;
    
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;
    
    @Column(name = "dni", nullable = false, unique = true, length = 20)
    private String dni;
    
    @Column(name = "celular", length = 20)
    private String celular;
    
    @Column(name = "correo", length = 100)
    private String correo;
    
    public Persona buscarP(String dni) {
        // Este método será implementado en el servicio
        return null;
    }
    
    public String nombreComp(String dni) {
        // Este método será implementado en el servicio
        return nombre + " " + apellido;
    }
}
