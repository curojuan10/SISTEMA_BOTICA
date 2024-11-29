package com.app.botica.service;

import com.app.botica.model.Caja;
import com.app.botica.repository.CajaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CajaService {
    @Autowired
    private CajaRepository cajaRepository;

    public List<Caja> listarCajas() {
        return cajaRepository.findAll();
    }

    public Caja obtenerCajaPorId(Integer id) {
        return cajaRepository.findById(id).orElse(null);
    }

    public Caja guardarCaja(Caja caja) {
        return cajaRepository.save(caja);
    }

    public void eliminarCaja(Integer id) {
        cajaRepository.deleteById(id);
    }
}
