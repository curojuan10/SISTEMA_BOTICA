package com.app.botica.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Caja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCaja;

    @Column(nullable = false)
    private java.sql.Timestamp fechaMovimiento;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoMovimiento tipoMovimiento;

    @Column(nullable = false)
    private Double monto;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    public enum TipoMovimiento {
        INGRESO,
        EGRESO
    }
}
