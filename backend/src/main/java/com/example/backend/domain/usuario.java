package com.example.backend.domain;

public class usuario {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private tipoUsuario tipo;

    public usuario() {}

    public usuario(Long id, String nome, String email, String senha, tipoUsuario tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public tipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(tipoUsuario tipo) {
        this.tipo = tipo;
    }
}
