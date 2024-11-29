package com.app.botica.controller;

import com.app.botica.model.Venta;
import com.app.botica.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/ventas")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @GetMapping("/listar")
    public List<Venta> listarVentas() {
        return ventaService.listarVentas();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Venta> obtenerVenta(@PathVariable Integer id) {
        Venta venta = ventaService.obtenerVentaPorId(id);
        return venta != null ? ResponseEntity.ok(venta) : ResponseEntity.notFound().build();
    }

    @PostMapping("/agregar")
    public Venta guardarVenta(@RequestBody Venta venta) {
        return ventaService.guardarVenta(venta);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable Integer id) {
        ventaService.eliminarVenta(id);
        return ResponseEntity.noContent().build();
    }
}
