package com.unifor.orfanato_batista.controller;

import com.unifor.orfanato_batista.dto.GaleriaRequest;
import com.unifor.orfanato_batista.model.Galeria;
import com.unifor.orfanato_batista.service.GaleriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/galeria")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class GaleriaController {

    private final GaleriaService galeriaService;

    @GetMapping
    public List<Galeria> listarTodas() {
        return galeriaService.listarTodasImagens();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Galeria salvarImagem(@RequestBody GaleriaRequest request) {
        return galeriaService.salvarImagem(request.getUrl());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarImagem(@PathVariable Long id) {
        galeriaService.deletarImagem(id);
    }
}