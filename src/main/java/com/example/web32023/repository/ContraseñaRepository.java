package com.example.web32023.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.web32023.entities.Contraseña;
import com.example.web32023.entities.Usuario;

public interface ContraseñaRepository extends JpaRepository <Contraseña, Integer>{
}
