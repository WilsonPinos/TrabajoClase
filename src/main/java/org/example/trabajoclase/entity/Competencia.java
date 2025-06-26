package org.example.trabajoclase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "competencia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Competencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_competencias")
    private Integer idCompetencias;
    
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "descripcion", length = 255)
    private String descripcion;
    
    public boolean sexisteComp(String nombre) {
        // Este método será implementado en el servicio
        return false;
    }
}
