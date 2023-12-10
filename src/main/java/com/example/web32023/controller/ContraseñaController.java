package com.example.web32023.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.web32023.entities.Contraseña;
import com.example.web32023.services.ContraseñaService;

import java.util.List;

@RestController
public class ContraseñaController {

    @Autowired
    private ContraseñaService contraseñaService;

    @GetMapping
    public ResponseEntity<List<Contraseña>> listarContraseñas() {
        List<Contraseña> contraseñas = contraseñaService.listarContraseñas();
        return ResponseEntity.ok(contraseñas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contraseña> obtenerContraseñaPorId(@PathVariable Integer id) {
        try {
            Contraseña contraseña = contraseñaService.obtenerContraseñaPorId(id);
            return ResponseEntity.ok(contraseña);
        } catch (ContraseñaNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Contraseña> crearContraseña(@RequestBody Contraseña contraseña) {
        try {
            Contraseña nuevaContraseña = contraseñaService.crearContraseña(contraseña);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaContraseña);
        } catch (ContraseñaExistenteException ex) {
            // Manejar el caso donde la contraseña ya existe
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contraseña> actualizarContraseña(@PathVariable Integer id, @RequestBody Contraseña contraseña) {
        try {
            Contraseña contraseñaActualizada = contraseñaService.actualizarContraseña(id, contraseña);
            return ResponseEntity.ok(contraseñaActualizada);
        } catch (ContraseñaNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContraseña(@PathVariable Integer id) {
        try {
            contraseñaService.eliminarContraseña(id);
            return ResponseEntity.noContent().build();
        } catch (ContraseñaNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}