package com.unifor.orfanato_batista.service;

import com.unifor.orfanato_batista.model.Contato;
import com.unifor.orfanato_batista.repository.ContatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContatoService {

    private final ContatoRepository contatoRepository;

    @Transactional
    public Contato salvarContato(Contato contato) {
        contato.setDataEnvio(LocalDateTime.now());
        return contatoRepository.save(contato);
    }

    @Transactional(readOnly = true)
    public List<Contato> listarTodos() {
        return contatoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Contato buscarPorId(Long id) {
        return contatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));
    }

    @Transactional
    public void deletarContato(Long id) {
        contatoRepository.deleteById(id);
    }
}