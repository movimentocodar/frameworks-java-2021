package br.com.codar.receitas.controller.dto;

import br.com.codar.receitas.model.Receita;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ListaReceitaDto {

    private Long id;
    private String nome;
    private String linkFoto;
    private Integer tempoPreparo;
    private Integer rendimento;
    private LocalDateTime dataPublicacao;

    public ListaReceitaDto(Receita receita){
        this.id = receita.getId();
        this.nome = receita.getNome();
        this.linkFoto = receita.getLinkFoto();
        this.tempoPreparo = receita.getTempoPreparo();
        this.rendimento = receita.getRendimento();
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

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public static List<ListaReceitaDto> converter(List<Receita> receitas) {
        return receitas.stream().map(ListaReceitaDto::new).collect(Collectors.toList());
    }
}
