package com.example.demo.Servicio;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Entidades.Usuario;
import com.example.demo.Repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public ResponseEntity<String> guardarUsuario(Usuario usuario) {
        usuarioRepositorio.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Creado el Usuario");
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepositorio.findById(id).get();
    }

}

