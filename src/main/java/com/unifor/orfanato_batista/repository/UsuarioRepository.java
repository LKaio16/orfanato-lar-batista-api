package com.unifor.orfanato_batista.repository;

import com.unifor.orfanato_batista.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNome(String nome);

    boolean existsByNome(String nome);
}