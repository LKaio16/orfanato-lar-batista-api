package com.unifor.orfanato_batista.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class ContatoResponseDTO {
    private Long id;
    private String nome;
    private String empresa;
    private String telefone;
    private String email;
    private String assunto;
    private String mensagem;
    private LocalDateTime dataEnvio;
}