package com.app.botica.controller;

import com.app.botica.model.Usuario;
import com.app.botica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Integer id) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    @PostMapping("/registrar")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
