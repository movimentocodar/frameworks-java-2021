package br.com.codar.receitas.controller.dto;

import br.com.codar.receitas.model.Receita;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetalheReceitaDto {
    private Long id;
    private String nome;
    private String linkFoto;
    private Integer tempoPreparo;
    private Integer rendimento;
    private String modoPreparo;
    private List<IngredienteDto> ingredientes;
    private LocalDateTime dataPublicacao;

    public DetalheReceitaDto(Receita receita) {
        this.id = receita.getId();
        this.nome = receita.getNome();
        this.linkFoto = receita.getLinkFoto();
        this.tempoPreparo = receita.getTempoPreparo();
        this.rendimento = receita.getRendimento();
        this.modoPreparo = receita.getModoPreparo();
        this.ingredientes = new ArrayList<>();
        this.ingredientes.addAll(receita.getIngredientes().stream().map(IngredienteDto::new).collect(Collectors.toList()));
        this.dataPublicacao = receita.getDataPublicacao();
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

    public List<IngredienteDto> getIngredientes() {
        return ingredientes;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }
}
