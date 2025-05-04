package com.example.backend.config;

import com.example.backend.domain.Categoria;
import com.example.backend.repository.CategoriaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoriaSeeder {

    @Bean
    CommandLineRunner inserirCategoriasFixas(CategoriaRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                // Criação das categorias fixas diretamente
                Categoria saude = new Categoria();
                saude.setNome("Saúde");
                repository.save(saude);

                Categoria educacao = new Categoria();
                educacao.setNome("Educação");
                repository.save(educacao);

                Categoria meioAmbiente = new Categoria();
                meioAmbiente.setNome("Meio Ambiente");
                repository.save(meioAmbiente);

                Categoria assistenciaSocial = new Categoria();
                assistenciaSocial.setNome("Assistência Social");
                repository.save(assistenciaSocial);

                Categoria cultura = new Categoria();
                cultura.setNome("Cultura");
                repository.save(cultura);
            }
        };
    }
}
