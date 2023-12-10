package com.example.web32023.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web32023.entities.Usuario;
import com.example.web32023.repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerUsuarioPorId(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizarUsuario(Integer id, Usuario usuario) {
        if (usuarioRepository.existsById(id)) {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        } else {
            throw new UsuarioNotFoundException("Usuario con ID " + id + " no encontrado");
        }
    }
}