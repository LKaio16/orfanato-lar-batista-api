package com.unifor.orfanato_batista.controller;

import com.unifor.orfanato_batista.model.Noticias;
import com.unifor.orfanato_batista.service.NoticiasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/noticias")
@RequiredArgsConstructor
public class NoticiasController {

    private final NoticiasService noticiasService;

    @GetMapping
    public ResponseEntity<List<Noticias>> listarTodas() {
        return ResponseEntity.ok(noticiasService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Noticias> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(noticiasService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Noticias> criar(@RequestBody Noticias noticia) {
        if (noticia.getData() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data do evento é obrigatória");
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(noticiasService.salvar(noticia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Noticias> atualizar(
            @PathVariable Long id,
            @RequestBody Noticias noticia) {
        return ResponseEntity.ok(noticiasService.atualizar(id, noticia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        noticiasService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}