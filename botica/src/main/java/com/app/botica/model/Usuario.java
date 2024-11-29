package com.app.botica.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(nullable = false, unique = true, length = 8)
    private String dni;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private String contraseña;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rol;

    @Column(nullable = false)
    private Boolean estado = true;

    public enum Rol {
        ADMIN, USER
    }
}
