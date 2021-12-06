package br.com.codar.receitas.controller.form;

import br.com.codar.receitas.model.Ingrediente;
import br.com.codar.receitas.model.Receita;
import br.com.codar.receitas.repository.IngredienteRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

public class ReceitaForm {

    @NotBlank(message = "{nomeReceita.NotBlank}")
    private String nome;
    private String linkFoto;
    @NotNull(message = "{tempoPreparo.NotNull}") @Min(value = 10, message = "{tempoPreparo.MinMax}") @Max(value = 360, message = "{tempoPreparo.MinMax}")
    private Integer tempoPreparo;
    @NotNull(message = "{rendimento.NotNull}") @Min(value = 1, message = "{rendimento.MinMax}") @Max(value = 50, message = "{rendimento.MinMax}")
    private Integer rendimento;
    @NotBlank(message = "{modoPreparo.NotBlank}") @Length(min = 20, message = "{modoPreparo.Length}")
    private String modoPreparo;
    private Boolean revisar;
    @NotNull(message = "{listaIngrediente.NotNull}")
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
