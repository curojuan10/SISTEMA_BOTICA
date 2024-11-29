package com.app.botica.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    @Column(nullable = false)
    private Date fechaVenta;

    @Column(nullable = false)
    private Double totalVenta;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;
}
