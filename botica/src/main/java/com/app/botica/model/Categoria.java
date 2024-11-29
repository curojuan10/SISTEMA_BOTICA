package com.app.botica.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;

    @Column(nullable = false, length = 100)
    private String nombreCategoria;

    private String descripcion;
}
