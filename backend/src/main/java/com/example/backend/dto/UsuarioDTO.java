package com.example.backend.dto;

import com.example.backend.domain.TipoUsuario;

public record UsuarioDTO(Long id, String nome, String email, TipoUsuario tipo) {
}
