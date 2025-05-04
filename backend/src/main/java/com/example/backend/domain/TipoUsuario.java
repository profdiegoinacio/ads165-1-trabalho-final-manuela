package com.example.backend.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoUsuario {
    VOLUNTARIO,
    ONG;

    @JsonCreator
    public static TipoUsuario fromString(String value) {
        return TipoUsuario.valueOf(value.toUpperCase());
    }
}
