package com.unifor.orfanato_batista.dto;

import com.unifor.orfanato_batista.model.Usuario;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String senha; // **OBS**: Em produção, evite expor a senha no DTO ou use criptografia.

    // Método estático para converter Entity -> DTO
    public static UsuarioDTO fromEntity(Usuario usuario) {
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .senha(usuario.getSenha())
                .build();
    }

    // Método estático para converter DTO -> Entity
    public static Usuario toEntity(UsuarioDTO dto) {
        return Usuario.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .senha(dto.getSenha())
                .build();
    }
}