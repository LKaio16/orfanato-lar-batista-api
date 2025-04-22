package com.unifor.orfanato_batista.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NoticiasDTO {
    private Long id;
    private String nome;
    private String descricao;
    private LocalDateTime data;
}