package com.unifor.orfanato_batista.service;

import com.unifor.orfanato_batista.model.Voluntario;
import com.unifor.orfanato_batista.repository.VoluntarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VoluntarioService {

    private final VoluntarioRepository voluntarioRepository;

    @Transactional
    public Voluntario cadastrarVoluntario(Voluntario voluntario) {
        voluntario.setDataEnvio(LocalDateTime.now());
        return voluntarioRepository.save(voluntario);
    }

    @Transactional
    public void deletarVoluntario(Long id) {
        if (!voluntarioRepository.existsById(id)) {
            throw new RuntimeException("Voluntário não encontrado com ID: " + id);
        }
        voluntarioRepository.deleteById(id);
    }

    public List<Voluntario> listarTodosVoluntarios() {
        return voluntarioRepository.findAll();
    }

    public Voluntario buscarVoluntarioPorId(Long id) {
        return voluntarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Voluntário não encontrado"));
    }}