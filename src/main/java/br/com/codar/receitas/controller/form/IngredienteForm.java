package br.com.codar.receitas.controller.form;

import br.com.codar.receitas.model.Ingrediente;
import br.com.codar.receitas.model.Medida;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class IngredienteForm {
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty @Min(1) @Max(1000)
    private Integer quantidade;
    @NotNull @NotEmpty @Enumerated(EnumType.STRING)
    private Medida medida;

    public IngredienteForm() {
    }

    public IngredienteForm(String nome, Integer quantidade, Medida medida) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.medida = medida;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setMedida(Medida medida) {
        this.medida = medida;
    }

    public Ingrediente converter() {
        return new Ingrediente(this.nome, this.quantidade, this.medida);
    }
}
