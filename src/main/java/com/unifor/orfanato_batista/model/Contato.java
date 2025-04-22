package com.unifor.orfanato_batista.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contatos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contato")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "empresa")
    private String empresa;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "assunto")
    private String assunto;

    @Column(name = "mensagem")
    private String mensagem;

    @Column(name = "data_envio")
    private LocalDateTime dataEnvio;
}