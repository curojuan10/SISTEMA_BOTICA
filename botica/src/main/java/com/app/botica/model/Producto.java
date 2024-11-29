package com.app.botica.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @Column(nullable = false, length = 100)
    private String nombreProducto;

    private String descripcion;

    @Column(nullable = false)
    private Integer cantidadDisponible;

    @Column(nullable = false)
    private Double precioUnitario;

    @Column(nullable = false)
    private java.sql.Date fechaVencimiento;

    @Column(nullable = false)
    private java.sql.Date fechaIngreso;

    @ManyToOne
    @JoinColumn(name = "idCategoria", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "idProveedor", nullable = false)
    private Proveedor proveedor;
}
