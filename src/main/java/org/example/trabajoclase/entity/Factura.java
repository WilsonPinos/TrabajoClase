package org.example.trabajoclase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factura")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Integer idFactura;
    
    @Column(name = "ruc", nullable = false, length = 20)
    private String ruc;
    
    @Column(name = "id_persona")
    private Integer idPersona;
    
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @Column(name = "id_tipo_pago")
    private Integer idTipoPago;
    
    @Column(name = "descuento")
    private Double descuento = 0.0;
    
    @Column(name = "total", nullable = false)
    private Double total;
    
    @ManyToOne
    @JoinColumn(name = "id_persona", insertable = false, updatable = false)
    private Persona persona;
    
    @ManyToOne
    @JoinColumn(name = "id_tipo_pago", insertable = false, updatable = false)
    private TipoPago tipoPago;
    
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<ItemFactura> items;
}
