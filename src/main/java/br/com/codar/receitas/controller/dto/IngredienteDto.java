package br.com.codar.receitas.controller.dto;

import br.com.codar.receitas.model.Ingrediente;
import br.com.codar.receitas.model.Medida;

public class IngredienteDto {
    private String nome;
    private Integer quantidade;
    private Medida medida;

    public IngredienteDto(Ingrediente ingrediente) {
        this.nome = ingrediente.getNome();
        this.quantidade = ingrediente.getQuantidade();
        this.medida = ingrediente.getMedida();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Medida getMedida() {
        return medida;
    }

    public void setMedida(Medida medida) {
        this.medida = medida;
    }
}
