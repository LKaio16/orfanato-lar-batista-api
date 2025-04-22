package com.unifor.orfanato_batista.service;

import com.unifor.orfanato_batista.dto.LoginDTO;
import com.unifor.orfanato_batista.dto.UsuarioResponseDTO;
import com.unifor.orfanato_batista.model.Usuario;
import com.unifor.orfanato_batista.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class UsuarioService {

    @Autowired UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    // Validação de login
    @Transactional(readOnly = true)
    public UsuarioResponseDTO validarLogin(LoginDTO loginDTO) {
        Usuario usuario = usuarioRepository.findByNome(loginDTO.nome());

        if (Objects.isNull(usuario)) {
            throw new RuntimeException("Usuario não encontrado");
        }

        if (!passwordEncoder.matches(loginDTO.senha(), usuario.getSenha())) {
            throw new RuntimeException("Senha incorreta");
        }

        return new UsuarioResponseDTO(usuario.getId(), usuario.getNome());
    }

    // (Opcional) Método para criar usuário com senha criptografada
    @Transactional
    public UsuarioResponseDTO criarUsuario(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        Usuario salvo = usuarioRepository.save(usuario);
        return new UsuarioResponseDTO(salvo.getId(), salvo.getNome());
    }
}