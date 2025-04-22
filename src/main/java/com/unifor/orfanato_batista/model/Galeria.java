package com.unifor.orfanato_batista.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "galeria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Galeria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_galeria")
    private Long id;

    @Lob
    @Column(name = "url", columnDefinition = "TEXT", length = 65535)
    private String url;

}
