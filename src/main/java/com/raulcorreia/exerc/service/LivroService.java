package com.raulcorreia.exerc.service;

import com.raulcorreia.exerc.dto.LivroCategoriaDTO;
import com.raulcorreia.exerc.exception.NotFoundException;
import com.raulcorreia.exerc.model.Categoria;
import com.raulcorreia.exerc.model.Livro;
import com.raulcorreia.exerc.repository.CategoriaRepository;
import com.raulcorreia.exerc.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;
    private final CategoriaRepository categoriaRepository;

    public Livro inserirLivro(Livro livro) {
        try {
            categoriaRepository.buscarPorId(livro.getCategoria_id());
            Long livroId = livroRepository.inserirLivro(livro);
            return buildLivro(livroId, livro);
        } catch (RuntimeException e) {
            throw new NotFoundException("A categoria informada não existe.");
        }

    }

    public List<LivroCategoriaDTO> buscarPorCategoria(String categoriaNome) {
        return livroRepository.buscarPorCategoria(categoriaNome);
    }
    
    private Livro buildLivro(Long livroId, Livro livro) {
        return Livro.builder()
                .id(livroId)
                .titulo(livro.getTitulo())
                .autor(livro.getAutor())
                .categoria_id(livro.getCategoria_id())
                .build();
    }

}
