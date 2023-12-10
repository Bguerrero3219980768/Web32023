package com.example.web32023.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.web32023.entities.Usuario;

public interface UsuarioRepository  extends JpaRepository <Usuario, Integer>{
}
