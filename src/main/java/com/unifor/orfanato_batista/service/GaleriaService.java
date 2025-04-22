package com.unifor.orfanato_batista.service;

import com.unifor.orfanato_batista.model.Galeria;
import com.unifor.orfanato_batista.repository.GaleriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GaleriaService {

    private final GaleriaRepository galeriaRepository;

    @Transactional(readOnly = true)
    public List<Galeria> listarTodasImagens() {
        return galeriaRepository.findAll();
    }

    @Transactional
    public Galeria salvarImagem(String imageUrl) {
        Galeria imagem = Galeria.builder()
                .url(imageUrl)
                .build();
        return galeriaRepository.save(imagem);
    }

    @Transactional
    public void deletarImagem(Long id) {
        galeriaRepository.deleteById(id);
    }
}