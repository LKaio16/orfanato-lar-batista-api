package com.unifor.orfanato_batista.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "noticia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Noticias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_noticia")
    private Long id;

    private String nome;

    private String descricao;

    private LocalDateTime data;
}
