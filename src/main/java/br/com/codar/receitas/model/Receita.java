package br.com.codar.receitas.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "receitas")
public class Receita {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String linkFoto;
    private Integer tempoPreparo;
    private Integer rendimento;
    private String modoPreparo;
    private Boolean revisar;
    @OneToMany
    private List<Ingrediente> ingredientes;
    private LocalDateTime dataPublicacao = LocalDateTime.now();

    public Receita() {
    }

    public Receita(String nome, String linkFoto, Integer tempoPreparo, Integer rendimento, String modoPreparo, Boolean revisar, List<Ingrediente> ingredientes) {
        this.nome = nome;
        this.linkFoto = linkFoto;
        this.tempoPreparo = tempoPreparo;
        this.rendimento = rendimento;
        this.modoPreparo = modoPreparo;
        this.revisar = revisar;
        this.ingredientes = ingredientes;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLinkFoto() {
        return linkFoto;
    }

    public Integer getTempoPreparo() {
        return tempoPreparo;
    }

    public Integer getRendimento() {
        return rendimento;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public Boolean getRevisar() {
        return revisar;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }
}
