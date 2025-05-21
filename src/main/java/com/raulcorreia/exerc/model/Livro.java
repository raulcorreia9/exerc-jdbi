package com.raulcorreia.exerc.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Livro {

    private Long id;
    private String titulo;
    private String autor;
    private Long categoria_id;
}
