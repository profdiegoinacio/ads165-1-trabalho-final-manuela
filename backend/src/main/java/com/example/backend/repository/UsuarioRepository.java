package com.example.backend.repository;

import com.example.backend.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Interface de repositório para operações CRUD de Usuário.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}