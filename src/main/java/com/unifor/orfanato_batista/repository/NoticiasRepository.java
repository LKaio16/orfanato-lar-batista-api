package com.unifor.orfanato_batista.repository;

import com.unifor.orfanato_batista.model.Noticias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiasRepository extends JpaRepository<Noticias, Long> {
}