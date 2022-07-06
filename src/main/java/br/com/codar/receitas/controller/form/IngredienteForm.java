package br.com.codar.receitas.controller.form;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;

public class IngredienteForm {

    private Long id;
    @NotEmpty(message = "Informe o nome do ingrediente")
    private String nomeIngrediente;

    @Range(min = 1, max = 1000, message = "A quantidade deve ser informada entre 1 a 1000")
    private Integer quantidade;
    @NotEmpty(message = "Selecione uma medida")
    private String medida;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeIngrediente() {
        return nomeIngrediente;
    }

    public void setNomeIngrediente(String nomeIngrediente) {
        this.nomeIngrediente = nomeIngrediente;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }


}
