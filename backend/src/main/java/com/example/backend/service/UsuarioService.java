package com.example.backend.service;

import com.example.backend.domain.Usuario;
import com.example.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario criarUsuario(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório.");
        }
        if (usuario.getEmail() == null || usuario.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email é obrigatório.");
        }

        return repository.save(usuario); // método do JpaRepository
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return repository.findById(id); // método do JpaRepository
    }

    public List<Usuario> listarUsuarios() {
        return repository.findAll(); // método do JpaRepository
    }

    public void deletarUsuario(Long id) {
        repository.deleteById(id); // método do JpaRepository
    }

    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        Optional<Usuario> usuarioExistente = repository.findById(id); // Use 'repository' aqui
        if (usuarioExistente.isPresent()) {
            Usuario usuarioParaAtualizar = usuarioExistente.get();
            usuarioParaAtualizar.setNome(usuario.getNome());
            usuarioParaAtualizar.setEmail(usuario.getEmail());
            usuarioParaAtualizar.setSenha(usuario.getSenha());
            usuarioParaAtualizar.setTipo(usuario.getTipo());
            return repository.save(usuarioParaAtualizar); // Use 'repository' aqui
        }
        throw new RuntimeException("Usuário não encontrado");
    }
}
