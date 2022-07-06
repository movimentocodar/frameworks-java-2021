package br.com.codar.receitas.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String linkFoto;

    private Integer tempoPreparo;
    private Integer rendimento;

    private String modoPreparo;

    @NotEmpty(message = "Nao pode ser nula")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "receita_id", referencedColumnName = "id")
    private List<Ingrediente> ingredientes = new ArrayList<>();
    private Boolean revisar;
    private LocalDateTime dataPublicacao = LocalDateTime.now();

    public Receita(Long id, String nome, String linkFoto, Integer tempoPreparo, Integer rendimento, List<Ingrediente> ingredientes, String modoPreparo, Boolean revisar) {
        this.id = id;
        this.nome = nome;
        this.linkFoto = linkFoto;
        this.tempoPreparo = tempoPreparo;
        this.rendimento = rendimento;
        this.ingredientes = ingredientes;
        this.modoPreparo = modoPreparo;
        this.revisar = revisar;
    }


    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }


    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDateTime dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Receita() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }

    public Integer getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(Integer tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public Integer getRendimento() {
        return rendimento;
    }

    public void setRendimento(Integer rendimento) {
        this.rendimento = rendimento;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }


    public Boolean getRevisar() {
        return revisar;
    }

    public void setRevisar(Boolean revisar) {
        this.revisar = revisar;
    }


}
