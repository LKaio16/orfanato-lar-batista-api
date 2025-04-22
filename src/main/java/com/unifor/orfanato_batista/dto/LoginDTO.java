package com.unifor.orfanato_batista.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
        @NotBlank(message = "Nome é obrigatório") String nome,
        @NotBlank(message = "Senha é obrigatória") String senha
) {}