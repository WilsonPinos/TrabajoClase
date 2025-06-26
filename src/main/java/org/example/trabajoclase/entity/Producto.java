package org.example.trabajoclase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;
    
    @Column(name = "stock", nullable = false)
    private Integer stock;
    
    @Column(name = "precio_unitario", nullable = false)
    private Double precioUnitario;
    
    @Column(name = "unidad", length = 20)
    private String unidad;
    
    @Column(name = "id_clasificacion")
    private Integer idClasificacion;
    
    @Column(name = "id_proveedor")
    private Integer idProveedor;
    
    @Column(name = "iva", nullable = false)
    private Boolean iva = false;
    
    @ManyToOne
    @JoinColumn(name = "id_clasificacion", insertable = false, updatable = false)
    private Clasificacion clasificacion;
    
    @ManyToOne
    @JoinColumn(name = "id_proveedor", insertable = false, updatable = false)
    private Proveedores proveedor;
}
