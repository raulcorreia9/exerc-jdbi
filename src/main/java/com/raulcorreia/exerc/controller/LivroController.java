package com.raulcorreia.exerc.controller;

import com.raulcorreia.exerc.model.Livro;
import com.raulcorreia.exerc.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/livros")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

    @PostMapping
    private ResponseEntity<Livro> inserirLivro(@RequestBody Livro livro) {
        try {
            return new ResponseEntity<>(livroService.inserirLivro(livro), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping()
    private ResponseEntity<Livro> getLivroByCategoria(@RequestParam String categoria) {
        try {
            return ResponseEntity.ok(new Livro());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
