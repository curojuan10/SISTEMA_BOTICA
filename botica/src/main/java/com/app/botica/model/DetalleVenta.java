package com.app.botica.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalle;

    @ManyToOne
    @JoinColumn(name = "idVenta", nullable = false)
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private Double subtotal;
}
