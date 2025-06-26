package org.example.trabajoclase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rol")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer idRol;
    
    @Column(name = "rol", nullable = false, length = 50)
    private String rol;
    
    @Column(name = "estado", nullable = false)
    private Boolean estado = true;
    
    public boolean sexisteRol(String rol) {
        // Este método será implementado en el servicio
        return false;
    }
    
    public boolean estado(String rol) {
        // Este método será implementado en el servicio
        return this.estado;
    }
}
