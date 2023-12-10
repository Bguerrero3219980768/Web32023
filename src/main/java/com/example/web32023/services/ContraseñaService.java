package com.example.web32023.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web32023.entities.Contraseña;
import com.example.web32023.repository.ContraseñaRepository;

import java.util.List;

@Service
public class ContraseñaService {

    @Autowired
    private ContraseñaRepository contraseñaRepository;

    public List<Contraseña> listarContraseñas() {
        return contraseñaRepository.findAll();
    }

    public Contraseña obtenerContraseñaPorId(Integer id) {
        Optional<Contraseña> contraseña = contraseñaRepository.findById(id);
        return contraseña.orElse(null);
    }

    public Contraseña crearContraseña(Contraseña contraseña) {
        return contraseñaRepository.save(contraseña);
    }

    public Contraseña actualizarContraseña(Integer id, Contraseña contraseña) {
        if (contraseñaRepository.existsById(id)) {
            contraseña.setId(id);
            return contraseñaRepository.save(contraseña);
        } else {
            throw new ContraseñaNotFoundException("Contraseña con ID " + id + " no encontrada");
        }
    }
}
