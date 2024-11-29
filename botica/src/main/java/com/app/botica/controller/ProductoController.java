package com.app.botica.controller;

import com.app.botica.model.Producto;
import com.app.botica.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/listar")
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id) {
        Producto producto = productoService.obtenerProductoPorId(id);
        return producto != null ? ResponseEntity.ok(producto) : ResponseEntity.notFound().build();
    }

    @PostMapping("/agregar")
    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Integer id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}
