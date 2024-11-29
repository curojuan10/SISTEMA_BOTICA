package com.app.botica.service;

import com.app.botica.model.Producto;
import com.app.botica.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto obtenerProductoPorId(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Integer id) {
        productoRepository.deleteById(id);
    }
}