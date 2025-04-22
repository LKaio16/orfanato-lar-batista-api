package com.unifor.orfanato_batista.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class VoluntarioRequestDTO {
    private String nome;
    private String email;
    private String telefone;
    private String habilidades;
    private List<String> disponibilidade;
    private String bio;
    private String motivo;
}