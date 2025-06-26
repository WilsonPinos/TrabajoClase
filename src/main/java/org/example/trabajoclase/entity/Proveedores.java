package org.example.trabajoclase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proveedores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedores {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer idProveedor;
    
    @Column(name = "ruc", nullable = false, unique = true, length = 20)
    private String ruc;
    
    @Column(name = "telefono", length = 20)
    private String telefono;
    
    @Column(name = "pais", length = 50)
    private String pais;
    
    @Column(name = "correo", length = 100)
    private String correo;
    
    @Column(name = "moneda", length = 10)
    private String moneda;
}
