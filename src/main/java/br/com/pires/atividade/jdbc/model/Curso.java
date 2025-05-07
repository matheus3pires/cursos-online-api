package br.com.pires.atividade.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    private Long id;
    private String titulo;
    private Double duracaoHoras;
    private Long instrutorId;
}

