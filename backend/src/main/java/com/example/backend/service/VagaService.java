package com.example.backend.service;

import com.example.backend.domain.Vaga;
import com.example.backend.domain.Usuario;
import com.example.backend.domain.Categoria;
import com.example.backend.repository.VagaRepository;
import com.example.backend.repository.UsuarioRepository;
import com.example.backend.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Lista todas as vagas
    public List<Vaga> listar() {
        return vagaRepository.findAll();
    }

    // Busca uma vaga por ID
    public Vaga buscarPorId(Long id) {
        return vagaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vaga não encontrada"));
    }

    // Salva uma nova vaga, associando Categoria e ONG
    @Transactional
    public Vaga salvar(Vaga vaga) {
        // Busca as entidades Categoria e ONG diretamente a partir do ID
        Usuario ong = usuarioRepository.findById(vaga.getOng().getId())
                .orElseThrow(() -> new EntityNotFoundException("ONG não encontrada"));

        Categoria categoria = categoriaRepository.findById(vaga.getCategoria().getId())
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));

        // Associa as entidades à vaga
        vaga.setOng(ong);
        vaga.setCategoria(categoria);

        // Salva a vaga
        return vagaRepository.save(vaga);
    }

    // Atualiza uma vaga existente
    @Transactional
    public Vaga atualizar(Long id, Vaga vagaAtualizada) {
        Vaga vaga = buscarPorId(id);

        vaga.setTitulo(vagaAtualizada.getTitulo());
        vaga.setDescricao(vagaAtualizada.getDescricao());
        vaga.setCategoria(vagaAtualizada.getCategoria());
        vaga.setOng(vagaAtualizada.getOng());

        return vagaRepository.save(vaga);
    }

    // Deleta uma vaga
    @Transactional
    public void deletar(Long id) {
        if (!vagaRepository.existsById(id)) {
            throw new EntityNotFoundException("Vaga não encontrada");
        }
        vagaRepository.deleteById(id);
    }
}
