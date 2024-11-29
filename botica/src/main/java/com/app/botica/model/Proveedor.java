package com.app.botica.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProveedor;

    @Column(nullable = false, length = 100)
    private String nombreProveedor;

    private String telefono;

    private String direccion;

    private String email;
}
