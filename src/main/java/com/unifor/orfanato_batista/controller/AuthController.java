package com.unifor.orfanato_batista.controller;

import com.unifor.orfanato_batista.dto.LoginDTO;
import com.unifor.orfanato_batista.dto.UsuarioResponseDTO;
import com.unifor.orfanato_batista.model.Usuario;
import com.unifor.orfanato_batista.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<UsuarioResponseDTO> login(@Valid @RequestBody LoginDTO loginDTO) {
        UsuarioResponseDTO response = usuarioService.validarLogin(loginDTO);
        return ResponseEntity.ok(response);
    }

    // (Opcional) Endpoint de registro
    @PostMapping("/registro")
    public ResponseEntity<UsuarioResponseDTO> registrar(@Valid @RequestBody Usuario usuario) {
        UsuarioResponseDTO response = usuarioService.criarUsuario(usuario);
        return ResponseEntity.ok(response);
    }
}