package com.unifor.orfanato_batista.repository;

import com.unifor.orfanato_batista.model.Galeria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GaleriaRepository extends JpaRepository<Galeria, Long> {
}