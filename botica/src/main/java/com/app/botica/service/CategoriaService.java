package com.app.botica.service;

import com.app.botica.model.Categoria;
import com.app.botica.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria obtenerCategoriaPorId(Integer id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void eliminarCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
