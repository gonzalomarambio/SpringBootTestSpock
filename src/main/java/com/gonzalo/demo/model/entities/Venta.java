package com.gonzalo.demo.model.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;

@Entity
@Table(name = "venta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fecha_venta")
    private LocalDateTime fechaVenta;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "departamento")
    private String departamento;
    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;

    @OneToOne
    @JoinColumn(name = "id_vendedor")
    private Vendedor vendedor;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<ProductoDetalle> productoDetalles;

    @OneToOne(mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private VentaPago ventaPago;

}