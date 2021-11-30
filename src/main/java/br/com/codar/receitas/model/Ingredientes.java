package br.com.codar.receitas.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Ingredientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer quantidade;
    @Enumerated(EnumType.STRING)
    private Medida medida;

}
