package com.app.botica.controller;

import com.app.botica.model.DetalleVenta;
import com.app.botica.service.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/detalle-ventas")
public class DetalleVentaController {
    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping("/listar")
    public List<DetalleVenta> listarDetalleVentas() {
        return detalleVentaService.listarDetalleVentas();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<DetalleVenta> obtenerDetalleVenta(@PathVariable Integer id) {
        DetalleVenta detalleVenta = detalleVentaService.obtenerDetalleVentaPorId(id);
        return detalleVenta != null ? ResponseEntity.ok(detalleVenta) : ResponseEntity.notFound().build();
    }

    @PostMapping("/agregar")
    public DetalleVenta guardarDetalleVenta(@RequestBody DetalleVenta detalleVenta) {
        return detalleVentaService.guardarDetalleVenta(detalleVenta);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarDetalleVenta(@PathVariable Integer id) {
        detalleVentaService.eliminarDetalleVenta(id);
        return ResponseEntity.noContent().build();
    }
}
