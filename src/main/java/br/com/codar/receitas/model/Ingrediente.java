package br.com.codar.receitas.model;

import javax.persistence.*;

@Entity
@Table(name = "ingredientes")
public class Ingrediente {

    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer quantidade;
    @Enumerated(EnumType.STRING)
    private Medida medida;

    public Ingrediente() {
    }

    public Ingrediente(String nome, Integer quantidade, Medida medida) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.medida = medida;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Medida getMedida() {
        return medida;
    }
}
