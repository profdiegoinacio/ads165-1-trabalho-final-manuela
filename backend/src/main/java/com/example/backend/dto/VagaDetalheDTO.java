package com.example.backend.dto;

public record VagaDetalheDTO(
        Long id,
        String titulo,
        String descricao,
        String categoria,
        String ongNome
) {}
