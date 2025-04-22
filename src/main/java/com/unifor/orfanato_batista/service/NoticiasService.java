package com.unifor.orfanato_batista.service;

import com.unifor.orfanato_batista.model.Noticias;
import com.unifor.orfanato_batista.repository.NoticiasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticiasService {

    private final NoticiasRepository noticiasRepository;

    @Transactional(readOnly = true)
    public List<Noticias> listarTodas() {
        return noticiasRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Noticias buscarPorId(Long id) {
        return noticiasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notícia não encontrada"));
    }

    @Transactional
    public Noticias salvar(Noticias noticia) {
        return noticiasRepository.save(noticia);
    }

    @Transactional
    public Noticias atualizar(Long id, Noticias noticiaAtualizada) {
        Noticias noticiaExistente = buscarPorId(id);
        noticiaExistente.setNome(noticiaAtualizada.getNome());
        noticiaExistente.setDescricao(noticiaAtualizada.getDescricao());
        return noticiasRepository.save(noticiaExistente);
    }

    @Transactional
    public void deletar(Long id) {
        noticiasRepository.deleteById(id);
    }
}