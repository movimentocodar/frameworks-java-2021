package br.com.codar.receitas.controller.form;

import br.com.codar.receitas.controller.dto.IngredienteDto;
import br.com.codar.receitas.model.Ingrediente;
import br.com.codar.receitas.model.Receita;
import br.com.codar.receitas.repository.IngredienteRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReceitaForm {

    @NotNull @NotBlank
    private String nome;
    private String linkFoto;
    @NotNull @Min(10) @Max(360)
    private Integer tempoPreparo;
    @NotNull @Min(1) @Max(50)
    private Integer rendimento;
    @NotNull @NotBlank @Length(min = 20)
    private String modoPreparo;
    private Boolean revisar;
    @NotNull
    private List<IngredienteForm> ingredientes;

    public ReceitaForm() {
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

    public List<IngredienteForm> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteForm> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Receita converter(IngredienteRepository ingredienteRepository) {
        List<Ingrediente> listaIngredientes = new ArrayList<>();
        this.ingredientes.forEach(i -> listaIngredientes.add(i.converter()));
        listaIngredientes.forEach(i -> ingredienteRepository.save(i));
        return new Receita(this.nome, this.linkFoto, this.tempoPreparo, this.rendimento, this.modoPreparo, this.revisar, listaIngredientes);
    }

}
