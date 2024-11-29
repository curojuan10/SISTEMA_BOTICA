package com.app.botica.controller;

import com.app.botica.model.Proveedor;
import com.app.botica.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("listar")
    public List<Proveedor> listarProveedores() {
        return proveedorService.listarProveedores();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Proveedor> obtenerProveedor(@PathVariable Integer id) {
        Proveedor proveedor = proveedorService.obtenerProveedorPorId(id);
        return proveedor != null ? ResponseEntity.ok(proveedor) : ResponseEntity.notFound().build();
    }

    @PostMapping("/registrar")
    public Proveedor guardarProveedor(@RequestBody Proveedor proveedor) {
        return proveedorService.guardarProveedor(proveedor);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Integer id) {
        proveedorService.eliminarProveedor(id);
        return ResponseEntity.noContent().build();
    }
}
