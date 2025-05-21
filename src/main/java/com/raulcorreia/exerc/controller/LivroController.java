package com.raulcorreia.exerc.controller;

import com.raulcorreia.exerc.model.Livro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @PostMapping
    private ResponseEntity<Livro> inserirLivro(Livro livro) {
        try {
            return new ResponseEntity<>(livro, HttpStatus.CREATED);
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
