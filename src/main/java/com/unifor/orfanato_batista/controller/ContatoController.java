package com.unifor.orfanato_batista.controller;

import com.unifor.orfanato_batista.model.Contato;
import com.unifor.orfanato_batista.service.ContatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contatos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ContatoController {

    private final ContatoService contatoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contato criar(@RequestBody Contato contato) {
        return contatoService.salvarContato(contato);
    }

    @GetMapping
    public List<Contato> listarTodos() {
        return contatoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Contato buscarPorId(@PathVariable Long id) {
        return contatoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        contatoService.deletarContato(id);
    }
}