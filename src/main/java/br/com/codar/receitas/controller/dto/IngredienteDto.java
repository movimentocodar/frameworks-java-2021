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


}
