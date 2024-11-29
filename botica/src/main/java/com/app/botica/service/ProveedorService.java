package com.app.botica.service;

import com.app.botica.model.Proveedor;
import com.app.botica.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> listarProveedores() {
        return proveedorRepository.findAll();
    }

    public Proveedor obtenerProveedorPorId(Integer id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public void eliminarProveedor(Integer id) {
        proveedorRepository.deleteById(id);
    }
}