package com.unifor.orfanato_batista.controller;

import com.unifor.orfanato_batista.model.Voluntario;
import com.unifor.orfanato_batista.service.VoluntarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voluntarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000") // Allow your React frontend
public class VoluntarioController {

    private final VoluntarioService voluntarioService;

    @GetMapping
    public ResponseEntity<List<Voluntario>> listarTodos() {
        return ResponseEntity.ok(voluntarioService.listarTodosVoluntarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voluntario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(voluntarioService.buscarVoluntarioPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Voluntario cadastrar(@RequestBody Voluntario voluntario) {
        return voluntarioService.cadastrarVoluntario(voluntario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 No Content
    public void deletar(@PathVariable Long id) {
        voluntarioService.deletarVoluntario(id);
    }


}