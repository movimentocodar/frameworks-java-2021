package br.com.codar.receitas.controller.form;

import br.com.codar.receitas.model.Ingrediente;
import br.com.codar.receitas.model.Medida;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;

public class IngredienteForm {
    @NotBlank(message = "{nomeIngrediente.NotBlank}")
    private String nome;
    @NotNull(message = "{quantidadeIngrediente.NotNull}") @Min(value = 1, message = "{quantidadeIngrediente.MinMax}") @Max(value = 1000, message = "{quantidadeIngrediente.MinMax}")
    private Integer quantidade;
    @NotNull(message = "{medidaIngrediente.NotNull}") @Enumerated(EnumType.STRING)
    private Medida medida;

    public IngredienteForm() {
    }

    public IngredienteForm(String nome, Integer quantidade, Medida medida) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.medida = medida;
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
