package com.raulcorreia.exerc.controller;

import com.raulcorreia.exerc.dto.LivroCategoriaDTO;
import com.raulcorreia.exerc.exception.NotFoundException;
import com.raulcorreia.exerc.model.Livro;
import com.raulcorreia.exerc.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

    @PostMapping
    private ResponseEntity<?> inserirLivro(@RequestBody Livro livro) {
        try {
            return new ResponseEntity<>(livroService.inserirLivro(livro), HttpStatus.CREATED);
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    private ResponseEntity<List<LivroCategoriaDTO>> buscarPorCategoria(@RequestParam String categoria) {
        try {
            return ResponseEntity.ok(livroService.buscarPorCategoria(categoria));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
