package com.raulcorreia.exerc.service;

import com.raulcorreia.exerc.model.Livro;
import com.raulcorreia.exerc.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    public Livro inserirLivro(Livro livro) {
        Long livroId = livroRepository.inserirLivro(livro);
        return buildLivro(livroId, livro);
    }

    //TODO validacao categoria e exceptions
    private Livro buildLivro(Long livroId, Livro livro) {
        return Livro.builder()
                .id(livroId)
                .titulo(livro.getTitulo())
                .autor(livro.getAutor())
                .categoria_id(livro.getCategoria_id())
                .build();
    }

}
