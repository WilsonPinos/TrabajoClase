package org.example.trabajoclase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clasificacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clasificacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clasificacion")
    private Integer idClasificacion;
    
    @Column(name = "grupo", nullable = false, length = 100)
    private String grupo;
}
