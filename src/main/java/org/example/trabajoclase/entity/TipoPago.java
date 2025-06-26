package org.example.trabajoclase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipo_pago")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoPago {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_pago")
    private Integer idTipoPago;
    
    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;
    
    @Column(name = "descripcion", length = 255)
    private String descripcion;
}
