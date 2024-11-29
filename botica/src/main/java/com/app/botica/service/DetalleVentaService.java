package com.app.botica.service;

import com.app.botica.model.DetalleVenta;
import com.app.botica.repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaService {
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public List<DetalleVenta> listarDetalleVentas() {
        return detalleVentaRepository.findAll();
    }

    public DetalleVenta obtenerDetalleVentaPorId(Integer id) {
        return detalleVentaRepository.findById(id).orElse(null);
    }

    public DetalleVenta guardarDetalleVenta(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    public void eliminarDetalleVenta(Integer id) {
        detalleVentaRepository.deleteById(id);
    }
}
