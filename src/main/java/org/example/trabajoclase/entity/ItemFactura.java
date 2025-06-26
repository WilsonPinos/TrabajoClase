package org.example.trabajoclase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item_factura")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemFactura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item_factura")
    private Integer idItemFactura;
    
    @Column(name = "id_factura")
    private Integer idFactura;
    
    @Column(name = "id_producto")
    private Integer idProducto;
    
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    
    @Column(name = "precio", nullable = false)
    private Double precio;
    
    @Column(name = "subtotal", nullable = false)
    private Double subtotal;
    
    @ManyToOne
    @JoinColumn(name = "id_factura", insertable = false, updatable = false)
    private Factura factura;
    
    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;
}
