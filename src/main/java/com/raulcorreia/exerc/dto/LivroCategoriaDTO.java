package com.raulcorreia.exerc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LivroCategoriaDTO {

    private Long id;
    private String titulo;
    private String autor;
    private String categoria;

}
