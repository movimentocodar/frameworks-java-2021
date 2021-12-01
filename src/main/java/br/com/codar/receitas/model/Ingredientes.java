package br.com.codar.receitas.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class Ingredientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotEmpty
    private String nome;
    @Min(1) @Max(1000)
    private Integer quantidade;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Medida medida;

    public Ingredientes(String nome, Integer quantidade, Medida medida) {
        setNome(nome);
        setQuantidade(quantidade);
        setMedida(medida);
    }
}
