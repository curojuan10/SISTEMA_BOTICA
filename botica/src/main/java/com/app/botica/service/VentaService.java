package com.app.botica.service;

import com.app.botica.model.Venta;
import com.app.botica.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

    public Venta obtenerVentaPorId(Integer id) {
        return ventaRepository.findById(id).orElse(null);
    }

    public Venta guardarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    public void eliminarVenta(Integer id) {
        ventaRepository.deleteById(id);
    }
}
