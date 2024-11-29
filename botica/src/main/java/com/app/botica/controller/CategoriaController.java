package com.app.botica.controller;

import com.app.botica.model.Categoria;
import com.app.botica.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listar")
    public List<Categoria> listarCategorias() {
        return categoriaService.listarCategorias();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Categoria> obtenerCategoria(@PathVariable Integer id) {
        Categoria categoria = categoriaService.obtenerCategoriaPorId(id);
        return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
    }

    @PostMapping("/agregar")
    public Categoria guardarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.guardarCategoria(categoria);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Integer id) {
        categoriaService.eliminarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
