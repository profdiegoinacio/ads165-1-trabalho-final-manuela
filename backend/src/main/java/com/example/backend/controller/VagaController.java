package com.example.backend.controller;

import com.example.backend.domain.Vaga;
import com.example.backend.service.VagaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vagas")
@CrossOrigin(origins = "http://localhost:3001")
public class VagaController {

    private final VagaService vagaService;

    // Injeção de dependência do VagaService
    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }

    // Método para listar todas as vagas
    @GetMapping
    public ResponseEntity<List<Vaga>> listar() {
        List<Vaga> vagas = vagaService.listar();
        return ResponseEntity.ok(vagas);
    }

    // Método para buscar uma vaga por ID
    @GetMapping("/{id}")
    public ResponseEntity<Vaga> buscarPorId(@PathVariable Long id) {
        try {
            Vaga vaga = vagaService.buscarPorId(id);
            return ResponseEntity.ok(vaga);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Método para criar uma nova vaga
    @PostMapping
    public ResponseEntity<Vaga> criar(@RequestBody Vaga vaga) {
        Vaga vagaCriada = vagaService.salvar(vaga);
        return ResponseEntity.status(201).body(vagaCriada);
    }

    // Método para atualizar uma vaga existente
    @PutMapping("/{id}")
    public ResponseEntity<Vaga> atualizar(@PathVariable Long id, @RequestBody Vaga vagaAtualizada) {
        try {
            Vaga vaga = vagaService.atualizar(id, vagaAtualizada);
            return ResponseEntity.ok(vaga);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Método para deletar uma vaga
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            vagaService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
