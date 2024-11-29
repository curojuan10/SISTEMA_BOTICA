package com.app.botica.controller;

import com.app.botica.model.Caja;
import com.app.botica.service.CajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/cajas")
public class CajaController {
    @Autowired
    private CajaService cajaService;

    @GetMapping("listar")
    public List<Caja> listarCajas() {
        return cajaService.listarCajas();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Caja> obtenerCaja(@PathVariable Integer id) {
        Caja caja = cajaService.obtenerCajaPorId(id);
        return caja != null ? ResponseEntity.ok(caja) : ResponseEntity.notFound().build();
    }

    @PostMapping("/agregar")
    public Caja guardarCaja(@RequestBody Caja caja) {
        return cajaService.guardarCaja(caja);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarCaja(@PathVariable Integer id) {
        cajaService.eliminarCaja(id);
        return ResponseEntity.noContent().build();
    }
}
