package com.unifor.orfanato_batista.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "voluntarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Voluntario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voluntario")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "habilidades", columnDefinition = "TEXT")
    private String habilidades;

    @ElementCollection
    @CollectionTable(name = "voluntario_disponibilidades", joinColumns = @JoinColumn(name = "voluntario_id"))
    @Column(name = "disponibilidade")
    private List<String> disponibilidade;

    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    @Column(name = "motivo", columnDefinition = "TEXT")
    private String motivo;

    @Column(name = "data_envio", nullable = false)
    private LocalDateTime dataEnvio;
}