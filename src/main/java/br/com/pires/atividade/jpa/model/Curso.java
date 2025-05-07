package br.com.pires.atividade.jpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String titulo;

    @Positive
    private Double duracaoHoras;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;
}
